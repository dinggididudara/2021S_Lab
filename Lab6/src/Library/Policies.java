package Library;

import java.util.Scanner;

/**
 * {@summary Policies interface : interface for calculating duedate and find, member class use this}

 */
public interface Policies {
	final int fine = 1; //fine of $1 after due dates, each day
	final int maxBooks = 5; //maximum 5 books they can borrow
	final int due = 14; //due date is 14 days
	
	abstract void whenIsDueDate(Scanner sc, int bookTotal); //member class use this
	abstract void howMuchFine(int days, int bookTotal); //member class use this
}
