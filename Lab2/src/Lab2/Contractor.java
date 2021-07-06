package Lab2;

import java.util.Scanner;

public class Contractor extends Employee{
		private double hourlyRate;
		private double numHours;
		protected double salary;
		@Override
		public void readEmployee(){//Scanner : asking user to input hourly rate and number of hours for contractor employee
			super.readEmployee();
			final Scanner SC = new Scanner(System.in);
			System.out.printf("Enter hourly rate: ");
			hourlyRate = SC.nextDouble();
			System.out.printf("Enter number of hours worked: ");
			numHours = SC.nextDouble();	
		}
		@Override
		public void printEmployee(){				//calculating salary
			salary = hourlyRate * numHours;
			super.printEmployee();					//sending salary info to super class(Employee class)
			System.out.printf("%12.2f |", salary);
		}
	}//class Contractor end