package CollegeSystem;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;

/**
 * {@summary : Student class (extends Person, implements Policies) : read student info, read user input / read, update file}
 * 
 */
public class Student extends Person implements Policies{
	protected static ObjectOutputStream outputObj;
	protected static ObjectInputStream inputObj;
	protected static FileInputStream fileInput;
	protected String typeOfStu;
	protected String line;
	
	public static String name;
	public int number;
	protected String programName;
	protected int studentNumber;
	protected int numberOfCourses;
	protected double total;
	protected double gpa;
	
	Student(){} //initialize
	
	Student(int studentNumber, String fname, String lname, String email, long phoneNum, String program, double gpa){
		super(fname, lname, email, phoneNum);
		this.studentNumber = studentNumber;
		program = programName;
		this.gpa = gpa;
	} 

	@Override
	void readInfo(Scanner sc) { //read Student info with scanner (user input)
		System.out.print("Enter program name: ");
		programName = sc.next();
		System.out.printf("Enter student number: ");
		studentNumber = sc.nextInt();

		super.PersonInfo(sc); //scan personal info from Person class
		readMarks(sc);
	}
	/**
	 * {@summary : readMarks(sc) : scan total courses and calculate Gpa}
	 * @param sc
	 */
	void readMarks(Scanner sc) {
		System.out.print("Enter number of courses: ");
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
	/**
	 * {@summary : openFile() : open students.txt file}
	 * 
	 */
	public void openFile(Scanner sc){	
		try { //open and read file
			Path p = Paths.get("src\\students.txt");
			sc = new Scanner(p); //get file
			while(sc.hasNextLine()){//if in the same line
				typeOfStu = sc.next();
				studentNumber = sc.nextInt();
				firstName = sc.next();
				lastName = sc.next();
				email = sc.next();
				phoneNumber = sc.nextLong();
				programName = sc.next();
				gpa = sc.nextDouble();
				new Student(studentNumber,firstName, lastName, email, phoneNumber, programName, gpa);
				if(typeOfStu.equals("f")) {//if full time student
					new FullTimeStudent(sc.nextDouble());
					College.students.add(this);
				} else if(typeOfStu.equals("p")) {//if part time student
					new ParttimeStudent(sc.nextDouble(), sc.nextDouble());
					College.students.add(this);
				}
			}//while ends
			sc.close();
		}catch(FileNotFoundException fe) {
			System.err.println("File not found or file not accessible");
		}catch(IOException e) {
			System.err.println("Error opening file");
		}//try-catch end
	}//openFile ends
	@Override
	void printInfo() {
		System.out.printf("%8s|%8d|%10s %s|%15s|%14d| %4.2f|", programName, studentNumber, firstName, lastName, email, phoneNumber, gpa);
	}
}
