package Library;

import java.util.Scanner;

public class Person {
	private String fname; //first name
	private String lname; //last name
	private String email; //email address
	private long phoneNumber; //phone number
	
	Person(Scanner sc){
		System.out.printf("What is your first name?: ");
		fname = sc.next();
		System.out.printf("What is your last name?: ");
		lname = sc.next();
		System.out.printf("What is your email?: ");
		email = sc.next();
		System.out.printf("What is your phone number?: ");
		phoneNumber = sc.nextLong();
	}
	
	public String getName() {
		return fname + " " + lname;
	}
}
