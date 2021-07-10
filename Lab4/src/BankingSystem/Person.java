package BankingSystem;
import java.util.Scanner;
/**
 * 
 * {@summary Person class : scanning personal info}
 *
 */
public class Person{
	protected String firstName;
	protected String lastName;
	protected String email;
	protected long phoneNumber;
	
	void readPersonalDetails(Scanner sc){ //scan all personal details
		System.out.printf("Enter first name: ");
		firstName = sc.next();
		System.out.printf("Enter last name: ");
		lastName = sc.next();
		System.out.printf("Enter email: ");
		email = sc.next();
		System.out.printf("Enter phone number: ");
		phoneNumber = sc.nextLong();
	}
	public String getName(){ //store name
		return firstName + " " + lastName;
	}
	public String getEmail() { //store email
		return email;
	}
	public long getPhoneNumber() { //store phone number
		return phoneNumber;
	}
}