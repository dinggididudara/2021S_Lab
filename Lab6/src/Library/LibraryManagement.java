package Library;

import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class LibraryManagement implements Policies{
	static String name; //library name
	public static void main(String[] args) {
		int option;
	
		Scanner sc = new Scanner(System.in);
		System.out.print("What is the library's name? : ");
		name = sc.next();
	
		try {
		while(true) {	
			
			System.out.println("1. Add Staff or Member from keyboard, then add to file(.lib)");
			System.out.println("2. Read,Print from file");
			System.out.println("3. Print staff's information");
			System.out.println("4. Print member's information");
			System.out.println("5. Exit");
			System.out.print("Choose your option: ");
			option = sc.nextInt();
			switch(option) {
				case 1:
					User.readUser(sc);
					break;
				case 2:
					print();
					Book.openBookFile();
					break;
				case 3:
					print();
					Library.printMember();
					break;
				case 4:
					print();
					Library.printStaff();
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
		}
		
	} //main end
	
	public static void print() {
		System.out.printf("%15s Library\n", name);
		System.out.println("***************************************");
	}

	@Override
	public void whenIsDueDate(Scanner sc) {
		System.out.print("How many days passed since borrowed? ");
		int days = sc.nextInt();
		howMuchFine(days);		
	}

	@Override
	public void howMuchFine(int days) {
		if(days<=14) {
			System.out.printf("Your due is %d days left.\n", (due-days));
		}else {
			System.out.printf("Too late. Your fine will be %d $\n", (days-due)*fine);
		} //if-else end
	} //howMuchFine end
	
} //LibraryManagement class end