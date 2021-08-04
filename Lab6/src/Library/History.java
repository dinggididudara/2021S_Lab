package Library;

import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class History extends NonFiction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2212715450013816766L;
	String title;
	String author;
	int year;
	History(Scanner sc){
		super(sc);
		System.out.print("Title: ");
		title = sc.nextLine();
		System.out.print("Author: ");
		author = sc.nextLine();
		System.out.print("Year: ");
		year = sc.nextInt();
	}
}
