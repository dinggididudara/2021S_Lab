package Lab2;

import java.util.Scanner;

public class Store{
	private Employee []employees;
	private Employee e;

	public Store() {}//initialize//empty it
	public Store(int num) {//defining the total length of employee array 
		employees = new Employee[num];
	}
	public void readEmployeeDetails() {//for loop(all employees): asking type of employee & direct to regular or contractor
		final Scanner SC = new Scanner(System.in);
		for(int i=0;i<employees.length;i++) {//user input type of employees //and repeat
			System.out.println("Enter details of employee:"+ (i+1));
			System.out.println("1.   Regular\n2.   Contractor");
			System.out.printf("Enter type of employee: ");
			int typeOfEmployee = SC.nextInt();	
			if(typeOfEmployee==1) {				//if regular
				employees[i] = new Regular();
			}else if(typeOfEmployee==2){		//if contractor
				employees[i] = new Contractor();
			}
			employees[i].readEmployee();
		}
	}
	public void printEmployeeDetails() {
		for(int i=0;i<employees.length;i++) {//declare employees class's array & print everything(for loop)
			employees[i].printEmployee();
			System.out.println("");
		}
	}
	public static void printLine() {
		for(int i=0;i<87;i++) {
			System.out.printf("=");
		}
		System.out.println("");
	}
	public static void printTitle(String storeName) {//storing the user input store name & print title with store name
		printLine();
		System.out.printf("%30s " + "Store Management System\n",storeName);
		printLine();
		System.out.printf("%10s | %20s | %16s | %15s | %12s |\n","Emp#","Name","Email","Phone","Salary");
		printLine();
	}	
}//class Store end
