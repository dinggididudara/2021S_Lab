package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class Comic extends Fiction{
	String title;
	String author;
	int year;
	Comic(Scanner sc){
		System.out.print("Title: ");
		title = sc.nextLine();
		System.out.print("Author: ");
		author = sc.nextLine();
		System.out.print("Year: ");
		year = sc.nextInt();
	}
}
