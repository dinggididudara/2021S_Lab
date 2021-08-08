package Library;

import java.io.Serializable;
import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class NonFiction extends Book implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String option;
	protected String categ;
	protected NonFiction nf;

	@Override
	public void readBooks(Scanner sc) {
		System.out.println("1. Science\n2. Biography\n3. History");
		System.out.print(":: ");
		option = sc.next();
		sc.nextLine();
			switch(option) {
			case "1":
			case "Science":
//				categ = "Science";
				nf = new Science();
				break;
			case "2":
			case "Biography":
//				categ = "Biography";
				nf = new Biography();
				break;
			case "3":
			case "History":
//				categ = "History";
				nf = new History();
			default:
				System.out.println("Wrong type! Try again");
			} //switch-case end
			nf.readBooks(sc);
			bookArr.add(nf);
			nf.writeBookFile(bookArr); //write objects to file
	} //read end

	@Override
	void print() {
		System.out.printf(" %10s |", categ);
	} //print end
} //NonFiction class end
