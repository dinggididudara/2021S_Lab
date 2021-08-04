package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class Biography extends NonFiction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8805257141838469923L;
	String title;
	String author;
	int year;
	Biography(Scanner sc){
		super(sc);
		System.out.print("Title: ");
		title = sc.nextLine();
		System.out.print("Author: ");
		author = sc.nextLine();
		System.out.print("Year: ");
		year = sc.nextInt();
	}
}
