package Library;

import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public abstract class Person {
	private String fname; //first name
	private String lname; //last name
	private String email; //email address
	private long phoneNumber; //phone number

	void PersonInfo(Scanner sc){
		System.out.print("What is your first name?: ");
		fname = sc.next();
		System.out.print("What is your last name?: ");
		lname = sc.next();
		System.out.print("What is your email?: ");
		email = sc.next();
		System.out.print("What is your phone number?: ");
		phoneNumber = sc.nextLong();
	} //PersonInfo end
	
	public String getName() {
		return fname + " " + lname;
	} //getName end
	
	abstract void read(Scanner sc);
	abstract void print();
}
