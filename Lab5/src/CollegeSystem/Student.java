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
	protected static FileInputStream fileInput;
	protected String typeOfStu;
	Student a;
	
	public static String name; //college name
	public int number;
	protected String programName;
	protected int studentNumber;
	protected int numberOfCourses;
	protected double total;
	protected double gpa;
	
	Student(){} //initialize
	/**
	 * 
	 * @param studentNumber student number from text file
	 * @param firstName first name from text file
	 * @param lastName last name from text file
	 * @param email email from text file
	 * @param phoneNumber phoneNumber from text file
	 * @param programName program name from text file
	 * @param gpa gpa from text file
	 */
	public void StudentFile(int studentNumber, String firstName, String lastName, String email, long phoneNumber, String programName, double gpa){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.studentNumber = studentNumber;
		this.programName = programName;
		this.gpa = gpa;
	} 
	public String getName() {
		return firstName + " " + lastName;
	}
	/**
	 * @param sc Scanner for reading user input
	 */
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
	 * @param sc for user input
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
			
			while(sc.hasNextLine()) {//if in the same line
				a = new Student();
				typeOfStu = sc.next();
				studentNumber = sc.nextInt();
				firstName = sc.next();
				lastName = sc.next();
				email = sc.next();
				phoneNumber = sc.nextLong();
				programName = sc.next();
				gpa = sc.nextDouble();
				if(typeOfStu.equals("f")) {//if full time student
					a = new FullTimeStudent(sc.nextDouble());
				} else if(typeOfStu.equals("p")) {//if part time student
					a = new ParttimeStudent(sc.nextDouble(), sc.nextDouble());
				}
				a.StudentFile(studentNumber,firstName, lastName, email, phoneNumber, programName, gpa);
				College.students.add(a);
			}//while ends
		sc.close();
		}catch(FileNotFoundException fe) {
			System.err.println("File not found or file not accessible");
		}catch(IOException e) {
			System.err.println("Error opening file");
		}//try-catch end
	}//openFile end
	/**
	 * {@summary printInfo() : priting student info}
	 */
	@Override
	void printInfo() {
		System.out.printf("%8s|%8d|%20s|%15s|%14d| %4.2f|", programName, studentNumber, getName(), email, phoneNumber, gpa);
	}
}
