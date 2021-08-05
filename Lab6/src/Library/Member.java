package Library;

import java.util.Scanner;
/**
 * {@summary Member class : implements Policies, get member's information}
 * 
 *
 */
public class Member extends User implements Policies{
	/**
	 * serial id for object writing
	 */
	private static final long serialVersionUID = 7059470493805464799L;
	String id; //member's id
	int age;
	int bookTotal;
	
	Member() {}
	
	void readMember(Scanner sc) {
		System.out.print("What is your member id?: ");
		id = sc.next();
		System.out.print("What is your age?: ");
		age = sc.nextInt();
		
		Book.readUserBook(sc);
		whenIsDueDate(sc);
	} //readMember end
	@Override
	public void whenIsDueDate(Scanner sc) {
		System.out.print("How many days passed since borrowed? ");
		int days = sc.nextInt();
		howMuchFine(days);		
	} //whenIsDueDate end

	@Override
	public void howMuchFine(int days) {
		if(days<=14) {
			System.out.printf("Your due is %d days left.\n", (due-days));
		}else {
			for(int i=0;i<5;i++) {
				int overdue = days-due;
				int totalFine = overdue*fine;
				System.out.printf("Too late. Your fine will be %d $\n", totalFine);
			} //for end
		}//if-else end
	} //howMuchFine end
}//Member class end
