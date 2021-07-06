package College;

import java.util.Scanner;

public abstract class Person {
	public static String firstName;
	public static String lastName;
	public static String emailId;
	public static long phoneNumber;
	Scanner sc = new Scanner(System.in);
	Person(){}
	void PersonInfo(){//scanning personal infos
		System.out.printf("Enter first name: ");
		firstName = sc.next();
		System.out.printf("Enter last name: ");
		lastName = sc.next();
		System.out.printf("Enter email Id: ");
		emailId = sc.next();
		System.out.printf("Enter phone number: ");
		phoneNumber = sc.nextLong();
	}
	
	abstract void readInfo();
	abstract void printInfo();
}
 