package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class Biography extends NonFiction{
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
