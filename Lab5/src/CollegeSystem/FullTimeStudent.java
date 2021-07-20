package CollegeSystem;

import java.util.Scanner;

/**
 * {@summary : FulltimeStudent class (extends Student class, implements Policies inteface) : get detail info of full time student}
 * 
 *
 */
public class FullTimeStudent extends Student{
	static double tuition;
	
	FullTimeStudent(){}	//initialize
	
	@Override
	void readInfo(Scanner sc) { //scan tuition fee
		super.readInfo(sc);
		System.out.printf("Enter tuition fees: ");
		tuition = sc.nextDouble();
	}
	
	@Override
	void printInfo() { //print details
		super.printInfo();
		System.out.printf("%8.2f|\n",tuition);
		
	}
}
