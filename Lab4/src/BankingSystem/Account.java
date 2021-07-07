package BankingSystem;

import java.util.Scanner;

public abstract class Account{
	protected int accType;
	protected long accNumber;
	Person accHolder;
	protected double balance;
	
	Account(){}
	public void readAccountDetails(Scanner sc){		
		System.out.printf("Enter Account Number: ");
		accNumber = sc.nextLong();
		
		accHolder = new Person();
		accHolder.readPersonalDetails(sc); //scan personal details (name, email, phone number)
		
		System.out.printf("Enter balance: ");
		balance = sc.nextDouble();
	}
	public void displayAccount(){
		Bank.printTitle();
		System.out.printf("%8d  | %s  | %15  | %18d  | %15.2f\n", accNumber, accHolder.getName(), accHolder.getEmail(), accHolder.getPhoneNumber(), balance);
	}
	abstract void updateBalance(); //define method in sub classes (Checking & Saving)	
}
