package BankingSystem;

import java.util.Scanner;

public class BankTest {
	public static void main(String[] args) {
		Bank b = new Bank(); 
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Enter the name of the bank: ");
		String name = sc.nextLine(); //scan bank's name
		System.out.printf("How many account holders do you have: ");
		int num = sc.nextInt(); //scan number of holders
		
		new Bank(name, num);
		
		for(int i=0;i<num;i++) {
			b.readAccounts(sc);//display menu, leading to options
		}
		sc.close();
	}
}
