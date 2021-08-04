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
	private static final long serialVersionUID = -5109869931526147556L;
	String title;
	String author;
	int year;
	Comic(Scanner sc){
		super(sc);
		System.out.print("Title: ");
		title = sc.nextLine();
		System.out.print("Author: ");
		author = sc.nextLine();
		System.out.print("Year: ");
		year = sc.nextInt();
	}
}
