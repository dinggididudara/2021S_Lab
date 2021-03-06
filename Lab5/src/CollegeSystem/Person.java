package CollegeSystem;

import java.util.Scanner;
/**
 * {@summary : abstract Person class : scan personal info from user}
 *
 */
public abstract class Person{
	String firstName;
	String lastName;
	String email;
	long phoneNumber;
	
	Person(){} //initialize
	Person(String firstName, String lastName, String email, long phoneNumber){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	void PersonInfo(Scanner sc){	//scan personal info
		System.out.print("Enter first name: ");
		firstName = sc.next();
		System.out.print("Enter last name: ");
		lastName = sc.next();
		System.out.print("Enter email Id: ");
		email = sc.next();
		System.out.print("Enter phone number: ");
		phoneNumber = sc.nextLong();
	}
	abstract void readInfo(Scanner sc); //it will be defined from child calsses
	abstract void printInfo(); //it will be defined from child classes
}