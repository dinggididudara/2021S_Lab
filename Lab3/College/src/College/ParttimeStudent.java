package College;

import java.util.Scanner;

public class ParttimeStudent extends Student{
	double courseFeeTotal;
	double credits;
	
	ParttimeStudent(){}
	@Override
	void readInfo() {
		super.readInfo();
		System.out.printf("Enter total course fees: ");
		Scanner sc = new Scanner(System.in);
		courseFeeTotal = sc.nextDouble();
		System.out.printf("Enter credit hours: ");
		credits = sc.nextDouble();
	}
	@Override
	void printInfo() {
		super.printInfo();
		System.out.printf("%8.2f|%10.2f|\n",courseFeeTotal, credits);
	}
}
