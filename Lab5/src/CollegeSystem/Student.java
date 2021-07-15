package CollegeSystem;

import java.io.IOException;

public class Student extends Person implements Policies{
	public static String name;
	public int number;
	protected String programName;
	protected int studentNumber;
	protected int numberOfCourses;
	protected double total;
	protected double gpa;
	
	Student(){}
	Student(String name, int number){
		this.name = name;
		this.number = number;
	}
	
	
	void readMarks(Scanner sc) {
		System.out.print("Enter program name: ");
		programName = sc.next();
		System.out.print("Enter number of courses: ");
		numberOfCourses = sc.nextInt();
		
		super.PersonInfo(); //from Person class, reading (name,email,phone number)
		readMarks();
	}
	
	@Override
	public void calculateGpa(Double...m) {
		for(Double i : m) {
			total += i;
		}
		gpa = total/(numberOfCourses*maxMarks)*maxGpa;
	}
	public static void writeObjects(Student []students) {
		try { //open file
			System.out.println("");
			
			
		}catch(IOException e) {
			System.out.println(e);
		}
		
//		try { //write objects
//			
//		}catch(IOEception e) {
//			System.out.println(e);
//		}
		
	}
	@Override
	void readInfo(Scanner sc) {
		new Person(sc);
		
	}
	@Override
	void printInfo() {
		System.out.printf(String.format("%7s|%8d|%8s %s|%13s|%14d| %.2f|", programName, studentNumber, firstName, lastName, email, phoneNumber, gpa));
		
	}
}
