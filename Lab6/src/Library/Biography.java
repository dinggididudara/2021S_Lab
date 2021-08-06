package Library;

import java.io.Serializable;
import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class Biography extends NonFiction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String title;
	String author;
	int year;
	@Override
	public void readBook(Scanner sc) {
		System.out.println("Title:");
		title = sc.nextLine();
		sc.nextLine();
		System.out.println("Author:");
		author = sc.nextLine();
		sc.nextLine();
		System.out.print("Year: ");
		year = sc.nextInt();
	} //read end
	
	@Override
	void print() {
		super.print();
		System.out.printf("| %20s | %20s | %5s \n", title, author, year);
	} //print end
}
