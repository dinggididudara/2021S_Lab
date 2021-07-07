package BankingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank{
	public static String name;
	ArrayList<Account> accounts; //Array List for class Account
	
	Bank(){} //initialize, empty it
	/**
	 * 
	 * @param name bank name
	 * @param num total number of holders
	 */
	Bank(String name,int num){//name and size from main
		this.name = name;
		accounts = new ArrayList<Account>();
		num = accounts.size();//total number of account holders
	}
	/**
	 * @param sc Scanner for reading accounts' info
	 * using for loop to 
	 */
	void readAccounts(Scanner sc){
		for(int i=0;i<accounts.size();i++) {
		System.out.println("1. Checking\n2. Savings");
		System.out.printf("Enter the type of account you want to create: ");
		int accType = sc.nextInt();	//scanning type of account
		
		if(accType==1) { //if checking account
			accounts.add(i,new Checking());
		} else if(accType==2) { //if saving account
			accounts.add(i,new Saving());
		} 
		accounts.get(i).readAccountDetails(sc);
		}
	}
		
	public void runMonthlyProcess() {
		if(accounts.isEmpty()==false) { //if not empty
			for(int i=0;i<accounts.size();i++) {
				accounts.get(i).updateBalance();;
			}
		}else {
			System.out.println("No accounts to process");
		}
	}

	void displayAccounts() {
		if(accounts.isEmpty()==false) { //if not empty
			printTitle(); 
			for(int i=0;i<accounts.size();i++) {
				accounts.get(i).displayAccount(); //display (printing) accounts from Account class
			}
		}
	}
	public static void printStar() {
		for(int i=0; i<50;i++ ) {
		System.out.printf("*");
		}
		System.out.println("");
	}
	public static void printTitle() {
		printStar();
		System.out.printf("%15s BANK\n", name);
		printStar();
		System.out.printf("Acc Number   |  Name |  Email |  Phone Number  |  Balance");
		printStar();
	}
}
