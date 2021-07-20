package CollegeSystem;

import java.util.Scanner;
/**
 * {@summary : abstract Person class : scan personal info from user}
 * @author Zhang
 *
 */
public abstract class Person{
	String firstName;
	String lastName;
	String email;
	long phoneNumber;
	
	Person(){} //initialize
	
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