package Library;

import java.io.Serializable;
import java.util.Scanner;
/**
 * {@summary History class : reading title, author, year}
 * 
 *
 */
public class History extends NonFiction implements Serializable{
	private static final long serialVersionUID = 1L;
	String title;
	String author;
	int year;
	/**
	 * @param sc Scanner
	 * {@summary readBooks method : ask user to input book's information}
	 */
	@Override
	public void readBooks(Scanner sc){
		categ = "History";
		System.out.println("Title:");
		title = sc.nextLine();
		System.out.println("Author:");
		author = sc.nextLine();
		System.out.print("Year:");
		year = sc.nextInt();
	}
	/**
	 * {@summary print method : override from Book class, print infos}
	 */
	@Override
	void print() {
		super.print();
		System.out.printf(" %10s | %10s | %4s |\n", title, author, year);
	}
}
