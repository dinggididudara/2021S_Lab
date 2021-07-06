package BankingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank extends BankTest{
	public static String name;
	ArrayList<Account> accounts = new ArrayList<Account>(); //type=Account object
//	ArrayList<Person> holders = new ArrayList<Person>();//type=Person object
	
	Bank(){}
	/**
	 * 
	 * @param name bank name
	 * @param num total number of holders
	 */
	Bank(String name,int num){//name and size from main
		this.name = name;
		num = accounts.size(); //total number of account holders
	}
	/**
	 * @param sc Scanner for reading accounts' info
	 * using try-catch, catching exception
	 */
	void readAccounts(Scanner sc){
		for(int i=0;i<accounts.size();i++){//if array list is not empty
			try{
				System.out.println("1. Read Accounts\n2.Run monthly process\n3.Display Accounts\n4.Exit");//printing menu
				System.out.println("Enter your option: ");
				int option = sc.nextInt();
			
				switch(option) { //switch for each options
				case 1 :
					accounts.add(null);
					//readAccountDetails(sc);
					break;
				case 2 :
					runMonthlyProcess();//run monthly process
					break;
				case 3:
					displayAccounts();//display accounts
					break;
				case 4:
					System.out.println("Goodbye... Have a nice day");
					break;
//				default :
//					System.out.println("Invalid entry... please try again!");
//					continue;
				}//switch-case end		
			}catch(Exception e) {
				System.out.println("Invalid entry... please try again!");
			}
		}
	}
	public void runMonthlyProcess() {
//		Checking.updateBalance();	//if checking
//		Saving.updateBalance(); 	//if saving
		
	}
	void displayAccounts() {
		printTitle();
		for(int i=0;i<accounts.size();i++) {
//			displayAccount(); //display (printing) accounts
		}
	}
	public static void printStar() {
		for(int i=0; i<30;i++ ) {
		System.out.printf("*");
		}
	}
	public static void printTitle() {
		printStar();
		System.out.printf("%15s BANK", name);
		printStar();
		System.out.printf("Acc Number   | %10s Name | %10s Email | %4s Phone Number $4s | %5s Balance");
		printStar();
	}
}
