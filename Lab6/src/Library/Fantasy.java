package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class Fantasy extends Fiction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3741879872338515361L;
	String title;
	String author;
	int year;
	Fantasy(Scanner sc){
		super(sc);
		System.out.print("Title: ");
		title = sc.nextLine();
		System.out.print("Author: ");
		author = sc.nextLine();
		System.out.print("Year: ");
		year = sc.nextInt();
	} //Fantasy end
} //Fantasy class end
