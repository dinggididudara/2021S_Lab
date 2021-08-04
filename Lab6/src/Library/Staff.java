package Library;

import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class Staff extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6348620923416425668L;
	String id; //staff id
	int floor;
	String section;
	
	Staff(){}
	
	void readStaff(Scanner sc) { //reading staff's information from keyboard
		super.readPerson(sc);
		System.out.print("What is your staff id?: ");
		id = sc.next();
		System.out.print("floor?: ");
		floor = sc.nextInt();
		System.out.print("section?: ");
		section = sc.next();
	}
}
