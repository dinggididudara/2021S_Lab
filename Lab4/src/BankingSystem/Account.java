package BankingSystem;

import java.util.Scanner;

public abstract class Account extends Bank{
	protected int accType;
	protected long accNumber;
	Person accHolder;
	protected double balance;
	
	Account(){}
	public void readAccountDetails(Scanner sc){
		System.out.println("1. Checking\n2.Savings");
		System.out.println("Enter the type of account you want to create: ");
		accType = sc.nextInt();	//scanning type of account
	
		for(;;) {
			if(accType==1) { //if checking account
				new Checking();
				break;
			} else if(accType==2) { //if saving account
				new Saving();
				break;
			} else { //if invalid number
				System.out.println("Invalid entry... please try again!");
				continue;
			}
		}
		System.out.printf("Enter Account Number: ");
		accNumber = sc.nextLong();
		
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
