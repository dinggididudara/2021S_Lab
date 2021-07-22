package CollegeSystem;

import java.util.Scanner;

/**
 * {@summary : FulltimeStudent class (extends Student class, implements Policies inteface) : get detail info of full time student}
 * 
 *
 */
public class FullTimeStudent extends Student{
	double tuition;
	
	FullTimeStudent(){}
	
	FullTimeStudent(double tuition){
		this.tuition = tuition;
	}	//for file
	
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
