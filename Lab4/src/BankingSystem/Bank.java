package BankingSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * {@summary Bank class actually running option from menu that users input}
 * 
 */
public class Bank{
	public static String name;
	ArrayList<Account> accounts; //Array List for class Account
	Account a = null;
	Bank(){} //initialize, empty it
	/**
	 * 
	 * @param name bank name
	 * @param num total number of holders - set array list size to this number
	 */
	Bank(String name,int num){//name and size from main
		this.name = name;
		accounts = new ArrayList<Account>();
		num = accounts.size();//total number of account holders
	}
	/**
	 * @param sc Scanner for reading accounts' info
	 */
	void readAccounts(Scanner sc){
			System.out.println("1. Checking\n2. Savings");
			System.out.printf("Enter the type of account you want to create: ");
			int accType = sc.nextInt();	//scanning type of account
		
			if(accType==1) { //if checking account
				a = new Checking();
			} else if(accType==2) { //if saving account
				a = new Saving();
			} 
		a.readAccountDetails(sc); //scan account number, balance, personal info
		accounts.add(a);
	}
	/**
	 * {@summary method runMonthlProcess : calculating all accounts, updateBalance(from Account class)}	
	 */
	public void runMonthlyProcess() {
		if(accounts.isEmpty()==false) { //if not empty
			for(int i=0;i<accounts.size();i++) {
				accounts.get(i).updateBalance();
			}
		}
	}
	/**
	 * {@summary method displayAccounts : printing all accounts (from Account class}
	 * 
	 */
	void displayAccounts() {
		printTitle(); 
		if(accounts.isEmpty()==false) { //if not empty
			for(int i=0;i<accounts.size();i++) {
				accounts.get(i).displayAccounts();//display (printing) accounts from Account class
			}
		}
	}
	public static void printStar() { //printing star for title
		for(int i=0; i<74;i++ ) {
		System.out.printf("*");
		}
		System.out.println("");
	}
	public static void printTitle() { //printing title with bank name
		printStar();
		System.out.printf("%40s BANK\n", name);
		printStar();
		System.out.printf(" Acc Number   |       Name  |     Email    |   Phone Number  |     Balance\n");
		printStar();
	}
}
