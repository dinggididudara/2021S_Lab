package BankingSystem;

import java.util.Scanner;

public class BankTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Enter the name of the bank: ");
		String name = sc.nextLine(); //scan bank's name
		System.out.printf("How many account holders do you have: ");
		int num = sc.nextInt(); //scan number of holders
		
		Bank b = new Bank(name, num); //pass name and num to Bank class
		
		while(num > 0) { //num is 
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
						break;
//				default :
//					System.out.println("Invalid entry... please try again!");
//					continue;
				}//switch-case end	
			}catch(Exception e) {//if user enter wrong inputs 
				System.out.println("Invalid entry... please try again!");
				return;
			}
			num--;
			return;
		}
	}
}
