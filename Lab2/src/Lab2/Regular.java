package Lab2;

import java.util.Scanner;

public class Regular extends Employee{
		protected double sal;//monthly

		@Override
		public void readEmployee() {//Scanner : asking user to input salary for regular employee 
			final Scanner SC = new Scanner(System.in);
			super.readEmployee();
			System.out.printf("Enter annual salary: ");
			sal=SC.nextDouble();
		}
		@Override
		public void printEmployee() {//calculating monthly salary & printing
			super.printEmployee();	//sending the salary info to super class(Employee class)
			System.out.printf("%12.2f |", sal/12);
		}
	}//class Regular end