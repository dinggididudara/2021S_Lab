package CollegeSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CollegeSystemTest {
	public static void main(String[] args) {
		String name;
		int number;
		int option;
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.print("Enter name of the college: ");
		name = sc.next();
		System.out.println("Enter number of students: ");
		number = sc.nextInt();
		
		new Student(name, number);
		
		while(true) {
			if(number>0){
				System.out.println("1. Read Students info from keyboard");
				System.out.println("2. Read Students info from file");
				System.out.println("3. Print details of all students");
				System.out.println("4. Exit");
				System.out.print("Enter your option: ");
				option = sc.nextInt();
				
				switch(option) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					System.out.println("Byebye... Have a nice day");
					System.exit(0);
				default:
					System.out.println("Invalid entry...selection options 1-4... please try again!");	
					continue;
				}
				
			}else {
				System.out.println("Number of students should be positive.. please try again!");
				continue;
			}
		}
		
		
		} catch (InputMismatchException e) {
			System.out.println("Input Mismatch Exception while reading number of students... please try again!");
		}
		
		
		
		
		
		
		sc.close();
	}
}
