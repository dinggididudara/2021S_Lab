package CollegeSystem;

import java.util.Scanner;

public abstract class Person{
	String firstName;
	String lastName;
	String email;
	long phoneNumber;
	
	Person(){}
	
	void PersonInfo(Scanner sc){	//scan personal info
		System.out.print("Enter first name: ");
		firstName = sc.next();
		System.out.print("Enter last name: ");
		lastName = sc.next();
		System.out.print("Enter email Id: ");
		email = sc.next();
		System.out.println("Enter phone number: ");
		phoneNumber = sc.nextLong();
	}
	abstract void readInfo(Scanner sc);
	abstract void printInfo();
}