package Library;

import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class History extends NonFiction{
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
