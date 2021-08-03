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
		System.out.println("1. Add Staff or Member from keyboard, then add to file(.lib)");
		System.out.println("2. Read from file");
		System.out.println("3. Print member's information");
		System.out.println("4. Exit");
		System.out.print("Choose your option: ");
		option = sc.nextInt();
		
		while(true) {	
			switch(option) {
				case 1:
					
					break;
				case 2:
					Book.openBookFile();
					break;
				case 3:
					
					break;
				case 4:
					sc.close();
					System.exit(0);
					break;
				default:
					continue;
			} //switch-case end
		} //while end
	} //main end
	
	public static void print() {
		System.out.printf("%5s Library\n", name);
		System.out.println("******************************");
	}
	
	@Override
	public void whenIsDueDate() { //calculate when is due date
		
		
	}

	@Override
	public void howMuchFine() { //calculate fine
		
		
	}
} //LibraryManagement class end