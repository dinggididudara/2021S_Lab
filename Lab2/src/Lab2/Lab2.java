package Lab2;
/*
 * Programmed by Soomin
 */
import java.util.Scanner;

public class Lab2 {
	public static void main(String[]args){
		final Scanner SC = new Scanner(System.in);
		System.out.printf("Enter name of the store: ");//first printing
		String storeName = SC.nextLine();
		
		System.out.printf("How many employees do you have? ");//2nd printing
		int num = SC.nextInt();
		
		Store s = new Store(num);//send total number of employees to Store class
		s.readEmployeeDetails();//reading all info 
		s.printTitle(storeName);//send store name to print	
		s.printEmployeeDetails();//printing all info including type										
	
	}
}//Lab2 class end