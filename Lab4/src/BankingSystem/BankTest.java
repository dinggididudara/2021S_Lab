package BankingSystem;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * {@summary BankTest class with main method}
 *
 */
public class BankTest {
	/**
	 * 
	 * {@summary scan bank and number (total number of holders)}
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = null;
		int num = 0;
				
		System.out.printf("Enter the name of the bank: ");
		name = sc.nextLine(); //scan bank's name
		System.out.printf("How many account holders do you have: ");
		num = sc.nextInt(); //scan number of holders
		
		Bank b = new Bank(name, num); //pass name and num to Bank class
		/**
		 * {@summary print options (=menu), leading to those options}
		 */
		do { 
			try{
				System.out.println("1. Read Accounts\n2. Run monthly process\n3. Display Accounts\n4. Exit");//printing menu
				System.out.printf("Enter your option: ");
				int option = sc.nextInt();
				switch(option) { //switch for each options
					case 1 :
						b.readAccounts(sc);//scanning info for accounts
						break;
					case 2 :
						b.runMonthlyProcess();//run monthly process
						break;
					case 3:
						b.displayAccounts();//display accounts
						break;
					case 4:
						System.out.println("Goodbye... Have a nice day");
						sc.close();
						System.exit(0);
				default :
					System.out.println("Invalid entry... please try again!");
					continue;
				}//switch-case end	
			}catch(InputMismatchException ie) {//if user enter wrong inputs 
				System.out.println("Invalid entry... please try again!");
				continue;
			}catch(Exception e) {//if no accounts yet
				System.out.println("No accounts to process");
				continue;
			}
		}while(num > 0);
	}
}
