package Library;

import java.util.Scanner;

/**
 * {@summary reading title, year of book}
 * 
 *
 */
public class Science extends NonFiction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5959835822560038222L;
	String title;
	String author;
	int year;
	
	@Override
	public void read(Scanner sc) {
		System.out.print("Title: ");
		title = sc.next();
		System.out.print("Author: ");
		author = sc.next();
		System.out.print("Year: ");
		year = sc.nextInt();
	} //read end
	
	@Override
	void print() {
		System.out.printf("| %20s | %20s | %5s", title, author, year);
	} //print end
} //Science class end
