package Library;

import java.util.Scanner;

public class LibraryManagement implements Policies{
	public static void main(String[] args) {
		String name; //library name
		int option;
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What is the library's name? : ");
		name = sc.next();
		System.out.println("1. Read from keyboard");
		System.out.println("2. Read from file");
		System.out.println("3. Check fines");
		System.out.print("Choose your option: ");
		option = sc.nextInt();
		while(true) {	
			switch(option) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					continue;
			} //switch-case end
		} //while end
	} //main end
	
	
	@Override
	public void whenIsDueDate() { //calculate when is due date
		
		
	}

	@Override
	public void howMuchFine() { //calculate fine
		
		
	}
} //LibraryManagement class end