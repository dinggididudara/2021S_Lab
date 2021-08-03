package Library;

import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class Staff extends User{
	String id; //staff id
	int floor;
	String section;
	
	Staff(){}
	
	void readStaff(Scanner sc) { //reading staff's information from keyboard
		System.out.print("What is your staff id?: ");
		id = sc.next();
		System.out.print("floor?: ");
		floor = sc.nextInt();
		System.out.print("section?: ");
		section = sc.next();
	}
}
