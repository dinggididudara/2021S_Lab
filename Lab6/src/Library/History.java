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
	
	@Override
	void read(Scanner sc){
		System.out.print("Title: ");
		title = sc.next();
		System.out.print("Author: ");
		author = sc.next();
		System.out.print("Year: ");
		year = sc.nextInt();
	}
	
	@Override
	void print() {
		System.out.printf("| %20s | %20s | %5s", title, author, year);
	}
}
