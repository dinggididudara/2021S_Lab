package Library;

import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class LibraryManagement{
	static String name; //library name
	public static void main(String[] args) {
		int option;
	
	
		Scanner sc = new Scanner(System.in);
		System.out.print("What is the library's name? : ");
		name = sc.next();
	
		try {
		while(true) {	
			System.out.println("1. Add Staff or Member from keyboard, then add to file(.lib)");
			System.out.println("2. Print Book lists");
			System.out.println("3. Print staff's information");
			System.out.println("4. Print member's information");
			System.out.println("5. Exit");
			System.out.print("Choose your option: ");
			option = sc.nextInt();
			switch(option) {
				case 1:
					Library.readDetails(sc);
					break;
				case 2:
					printBookTable();
					Book.openBookFile();
					Book.print();
					break;
				case 3:
					printStaffTable();
					Library.printDetailsStaff();
					break;
				case 4:
					printMemberTable();
					Library.printDetailsStaff();
					break;
				case 5:
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Wrong type! please try again");
					continue;
			} //switch-case end
		} //while end
		} catch(Exception e) {
			System.err.println("please try again");
		} //try-catch end
		
	} //main end
	
	public static void printLibraryName() {
		System.out.printf("%15s Library\n", name);
		System.out.println("***************************************");
	} //print end
	
	public static void printStaffTable() {
		printLibraryName();
		System.out.println(" Name | Staff Id | Section | ");
	}
	
	public static void printMemberTable() {
		printLibraryName();
		System.out.println(" Name | Member Id | Books | OverDue | Fine |");
	}
	
	public static void printBookTable() {
		printLibraryName();
		System.out.println("Category | Title | Author | Year |");
	}
} //LibraryManagement class end