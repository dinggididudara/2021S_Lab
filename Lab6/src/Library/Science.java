package Library;

import java.util.Scanner;

/**
 * {@summary reading title, year of book}
 * 
 *
 */
public class Science extends NonFiction{
	String title;
	String author;
	int year;
	Science(Scanner sc){
		super(sc);
		System.out.print("Title: ");
		title = sc.nextLine();
		System.out.print("Author: ");
		author = sc.nextLine();
		System.out.print("Year: ");
		year = sc.nextInt();
	} //Science end
} //Science class end
