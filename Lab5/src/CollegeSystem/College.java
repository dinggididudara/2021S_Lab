package CollegeSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * {@summary : College class, scan details of student}
 * @author Zhang
 *
 */
public class College extends CollegeSystemTest{
	public static String name;
	public static ArrayList<Student> students;	
	Student s;
	
	/**
	 * {@summary : College(name,num) : save variables of college and total number}
	 * @param name : College name
	 * @param num : total number of students, assign in array
	 */
	College(String name, int num){
		this.name = name;
		students = new ArrayList<Student>(num);//total number of students (ArrayList's 'capacity' is 'num')
	}//College ends
	/**
	 * {@summary : readStudentDetails() : scanning students' type (Fulltime or Parttime)}
	 * @param sc : scanner
	 */
	void readStudentDetails(Scanner sc, int num) {		
		for(int i=0;i<num;i++) {
			System.out.println("Enter details of student "+ (i+1) + ":");
			System.out.println("=============================");
			try {
				System.out.println("1 - Fulltime Student\n2 - Parttime Student");
				System.out.printf("Enter Student type: ");
				int type = sc.nextInt();
				if(type==1) {//for Fulltime Student
					s = new FullTimeStudent();
				}else if(type==2) {//for Parttime Student
					s = new ParttimeStudent();
				}else {
					System.out.println("Wrong student type");
					continue;
				}
				s.readInfo(sc);
				students.add(s);
			}catch(InputMismatchException e) {
				System.err.println("Input Mismatch Exception while reading student type");
			}//try-catch ends
		}//for ends
	}//readStudentDetails end
	/**
	 * {@summary : printTitle() : print lines}
	 */
	static public void printTitle() { //print lines
		for(int i=0;i<90;i++) {
			System.out.print("=");
		}
		System.out.println("");
	}
	/**
	 * {@summary : printDisplay() : print titles for option 3}
	 */
	static public void printDisplay() {
		printTitle();
		System.out.printf("%35s College - List of Students\n", name);
		printTitle();
		System.out.printf(" Program|Student#|             Name|          Email|         Phone|  Gpa|    Fees| Credits|\n");
	}
	/**
	 * {@summary : printAllInfos() : print all info of student array}
	 */
	void printStudentsDetails(int num) { //printing all info from user input
		if(students.isEmpty()==false) { //if not empty
			printDisplay();
			for(int i=0;i<num;i++) {
				students.get(i).printInfo();
			}
		}else {
			System.out.println("######## No student to display ########");
		}//if ends
	}//printAllInfos ends
}
