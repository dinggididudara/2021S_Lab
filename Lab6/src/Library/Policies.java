package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public interface Policies {
	final int fine = 1; //fine of $1 after due dates, each day
	final int maxBooks = 5; //maximum 5 books they can borrow
	final int due = 14; //due date is 14 days
	
	abstract int whenIsDueDate(Scanner sc, int bookTotal);
	abstract int howMuchFine(int days, int bookTotal);
}
