package Library;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * {@summary LibraryManagement class : main class that perform all menus}
 */
public class LibraryManagement implements Serializable{
	private static final long serialVersionUID = 1L;
	static String name; //library name
	/**
	 * {@summary main method : print menu and perform all options}
	 * @param args
	 */
	public static void main(String[] args) {
		int option;
	
		Scanner sc = new Scanner(System.in);
		System.out.print("What is the library's name? : ");
		name = sc.next();
		Library l = new Library();
		
		try {
		while(true) {	//print options
			System.out.println("1. Add Staff or Member from keyboard, then add to file(.lib)");
			System.out.println("2. Print Book lists");
			System.out.println("3. Print staff's information");
			System.out.println("4. Print member's information");
			System.out.println("5. Exit");
			System.out.print("Choose your option: ");
			option = sc.nextInt();
			switch(option) {
				case 1:
					l.readDetails(sc);
					break;
				case 2:
					printBookTable();
					Book.openBookFile();
					break;
				case 3:
					printStaffTable();
					User.openStaffFile();
					break;
				case 4:
					printMemberTable();
					User.openMemberFile();
					break;
				case 5:
					System.out.println("Bye");
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Wrong type! please try again");
					continue;
			} //switch-case end
		} //while end
		} catch(InputMismatchException e) {
			System.err.println("Input Mismatch Exception");
		} catch(Exception e) {
			System.err.println("please try again");
		} //try-catch end
	} //main end
	/**
	 * {@summary printStaffTable method : table for staff (menu 3)}
	 */
	public static void printStaffTable() {
		System.out.println("");
		System.out.printf("\t \t \t%s Library\n", name); 
		for(int i=0;i<67;i++) {
			System.out.print("*");
			} //for end
		System.out.println("");
		System.out.println("\t \t \t Staff List\n");
		System.out.println("      Name      |    email    | phone Number | Staff Id | Section |");
	} //printStaffTable end
	/**
	 * {@summary printMemberTable method : table for member (menu 4)}
	 */
	public static void printMemberTable() {
		System.out.println("");
		System.out.printf("\t \t \t \t%s Library\n", name);
		for(int i=0;i<83;i++) {
			System.out.print("*");
			} //for end
		System.out.println("");
		System.out.println("\t \t \t \t Member List\n");
		System.out.println("      Name      |    email    | phone Number | Member Id | Books | OverDue | Fine |");
	} //printMemberTable end
	/**
	 * {@summary printBookTable method : table for book list (menu 2)}
	 */
	public static void printBookTable() {
		System.out.println("");
		System.out.printf("\t \t  %s Library\n", name);
		for(int i=0;i<46;i++) {
			System.out.print("*");
			} //for end
		System.out.println("");
		System.out.println("\t \t   Book List\n");
		System.out.println("  Category  |    Title   |   Author   | Year |");
	} //printBookTable end
} //LibraryManagement class end