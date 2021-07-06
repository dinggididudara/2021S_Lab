package Lab2;

import java.util.Scanner;

public class Employee{	
	private Person p;//Object
	private int employeeNumber;
	private double salary;
	int i;

	
	Employee() {}//initialize//empty it
	Employee(int employeeNumber, String fName, String lName, String email, long phoneNumber, double salary){
		this.employeeNumber=employeeNumber;
		this.salary=salary;
		p = new Person(fName,lName,email,phoneNumber);
	}	
	public void readEmployee(){
		final Scanner SC = new Scanner(System.in);
		
		System.out.printf("Enter Employee Number: ");
		employeeNumber=SC.nextInt();
		System.out.printf("Enter first name: ");
		String firstName = SC.next();
		System.out.printf("Enter last name: ");
		String lastName = SC.next();			
		System.out.printf("Enter email: ");
		String email = SC.next();
		System.out.printf("Enter phone number: ");
		long phoneNumber = SC.nextLong();
		p = new Person (firstName, lastName, email, phoneNumber);
	}
	public void printEmployee(){//printing info from user input(from Person class) and employeeNumber from Employee class's method(readEmployee)
		System.out.printf("%10d | %20s | %16s | %15d  |", employeeNumber, p.getName(), p.getEmail(), p.getPhoneNumber());
	}
	public double getSalary() {//store salary info(using getter)
		return salary;
	}
}//Employee class end