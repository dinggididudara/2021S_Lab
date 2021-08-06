package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class Comic extends Fiction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String title;
	String author;
	int year;
	
	@Override
	public void readBook(Scanner sc) {
		System.out.print("Title: ");
		title = sc.next();
		System.out.print("Author: ");
		author = sc.next();
		System.out.print("Year: ");
		year = sc.nextInt();
	} //read end
	
//	@Override
	void print() {
		System.out.printf("| %20s | %20s | %5s", title, author, year);
	} //print end
}
