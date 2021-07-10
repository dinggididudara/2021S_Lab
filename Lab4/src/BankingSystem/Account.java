package BankingSystem;

import java.util.Scanner;
/**
 * 
 * {@summary Account class is scanning details of account}
 *
 */
public abstract class Account{
	protected int accType;
	protected long accNumber;
	Person accHolder;
	protected double balance;
	
	Account(){}
	/**
	 * 
	 * @param sc Scanning account details + using Person class
	 */
	public void readAccountDetails(Scanner sc){		
		System.out.printf("Enter Account Number: ");
		accNumber = sc.nextLong();
		
		accHolder = new Person();
		accHolder.readPersonalDetails(sc); //scan personal details (name, email, phone number)
		
		System.out.printf("Enter balance: ");
		balance = sc.nextDouble();
	}
	/**
	 * {@summary diaplayAccounts method : printing all info}
	 */
	public void displayAccounts(){
		System.out.printf("%12d  | %10s  | %11s  | %14d  | %11.2f \n", accNumber, accHolder.getName(), accHolder.getEmail(), accHolder.getPhoneNumber(), balance);
	}
	abstract void updateBalance(); //define method in sub classes (Checking & Saving)	
}
