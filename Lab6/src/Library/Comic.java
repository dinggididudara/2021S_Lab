package Library;

import java.io.Serializable;
import java.util.Scanner;

/**
 * {@summary Comic class : reading title, year of book}
 * 
 *
 */
public class Comic extends Fiction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String title;
	String author;
	int year;
	/**
	 * {@summary readBooks method : ask user to input book's information}
	 * @param sc Scanner
	 */
	@Override
	public void readBooks(Scanner sc) {
		categ = "Comic";
		System.out.println("Title:");
		title = sc.nextLine();
		System.out.println("Author:");
		author = sc.nextLine();
		System.out.print("Year: ");
		year = sc.nextInt();
	} //read end
	/**
	 * {@summary print method : override from Book class, print infos}
	 */
	@Override
	void print() {
		super.print();
		System.out.printf(" %10s | %10s | %4s |\n", title, author, year);
	} //print end
}
