package College;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person implements Policies{
	
	private String programName;
	private int studentNumber;
	private int numberOfCourses;
	private double total;
	private double gpa;
	
	Scanner sc = new Scanner(System.in);
	
	Student(){}
	
	@Override
	void readInfo(){//reading student infos
		
		System.out.printf("Enter Program name: ");
		programName=sc.next();
		System.out.printf("Enter student number: ");
		studentNumber = sc.nextInt();
		
		super.PersonInfo();//from Person class, reading <name, email, phone number>	
		readMarks();
	}
	void readMarks() {
		System.out.printf("Enter number of courses: ");
		numberOfCourses = sc.nextInt();
		ArrayList<Double> marks = new ArrayList<Double>();
		for(int i=0;i<numberOfCourses;i++) {
			System.out.printf("Enter mark " + (i+1) + ": ");
			double m = sc.nextDouble();
			marks.add(m);
			calculateGpa(marks.get(i));
		}
	}
	@Override
	public void calculateGpa(Double...m) {
		for(Double i : m) {
			total += i;
		}
		gpa = total/(numberOfCourses*maxMarks)*maxGpa;
	}
	
	@Override
	void printInfo() {
		System.out.printf(String.format("%7s|%8d|%8s %s|%13s|%14d| %.2f|", programName, studentNumber, firstName, lastName, emailId, phoneNumber, gpa));
	}
}
