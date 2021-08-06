package Library;

import java.io.Serializable;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public abstract class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String fname; //first name
	protected String lname; //last name
	protected String email; //email address
	protected long phoneNumber; //phone number

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
	
	abstract void read(Scanner sc);
	abstract void print();
}
