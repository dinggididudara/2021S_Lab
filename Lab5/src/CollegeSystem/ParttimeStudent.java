package CollegeSystem;

import java.util.Scanner;

/**
 * {@summary : ParttimeStudent class (extends Student class, implements Policies inteface) : get detail info of part time student}
 * 
 *
 */
public class ParttimeStudent extends Student implements Policies{
	double totalCourseFee;
	double credits;

	ParttimeStudent(){} //initialize
	
	ParttimeStudent(double totalCourseFees, double credits){
		totalCourseFee = totalCourseFees;
		this.credits = credits;
	}
	
	@Override
	void readInfo(Scanner sc) { //scan course fees, credits
		super.readInfo(sc);
		System.out.printf("Enter total course fees: ");
		totalCourseFee = sc.nextDouble();
		System.out.printf("Enter credit hours: ");
		credits = sc.nextDouble();
	}
	@Override
	void printInfo() { //print details
		super.printInfo();
		System.out.printf("%8.2f|%10.2f|\n",totalCourseFee, credits);
	}
}
