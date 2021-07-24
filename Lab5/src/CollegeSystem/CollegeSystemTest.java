package CollegeSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * {@summary : CollegeSystemTest, main class}
 * @author Soomin 040899389
 *
 */
public class CollegeSystemTest {
	/**
	 * {@summary : Main method, printing options for user}
	 * @param args
	 */
	public static void main(String[] args) {
		String name;
		int number;
		int option;
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name of the college: ");
		name = sc.next();
		System.out.print("Enter number of students: ");
		number = sc.nextInt();
		
		College c = new College(name, number);
		if(number>0) {
			do{
				try {
					Student s = new Student();
					System.out.println("1. Read Students info from keyboard");
					System.out.println("2. Read Students info from file");
					System.out.println("3. Print details of all students");
					System.out.println("4. Exit");
					System.out.print("Enter your option: ");
					option = sc.nextInt();
				
					switch(option) {
					case 1: //read students info using scanner
						c.readStudentDetails(sc, number);
						break;
					case 2: //read info from file <- Student class
						s.openFile(sc);
						break;
					case 3: //print(display all)
						c.printStudentsDetails(number);
						break;
					case 4:
						System.out.println("Byebye... Have a nice day");
						sc.close();
						System.exit(0);
					default:
						System.err.println("Invalid entry...selection options 1-4... please try again!");	
					}//switch-case end
					
				}catch (InputMismatchException ie) { //if input is not match
					System.err.println("Input Mismatch Exception while reading number of students... please try again!");
			}//try-catch ends
		}while(number>0);//do-while ends
		}else if(number<=0) {	
			System.out.println("Number of students should be positive.. please try again!");
		}//if ends
		sc.close();	
	}//main ends
}//class ends
