package Library;

import java.io.Serializable;
import java.util.Scanner;
/**
 * {@summary Fiction class : if user input fiction as a book category}
 * 
 *
 */
public class Fiction extends Book implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String option;
	protected String categ;
	protected Fiction f;
	/**
	 * {@summary readBooks method : override from Book class, read category of book}
	 * #
	 */
	@Override
	public void readBooks(Scanner sc) {
		System.out.println("1. Comic\n2. Fantasy");
		System.out.print(":: ");
		option = sc.next();
		sc.nextLine();
		switch(option) {
		case "1":
		case "Comic":
			f = new Comic();
			break;
		case "2":
		case "Fantasy":
			f = new Fantasy();
			break;
		default:
			System.out.println("Wrong type! Try again");
		} //switch-case end 
		f.readBooks(sc);
		bookArr.add(f);
		f.writeBookFile(bookArr); //write objects to file
	} //read end
	/**
	 * {@summary print method : override from book class, print book's category}
	 */
	@Override //override from abstract class (Book class)
	void print() {
		System.out.printf(" %10s |", categ);
	} //print end
} //Fiction class end
