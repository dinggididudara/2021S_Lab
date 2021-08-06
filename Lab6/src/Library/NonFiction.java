package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class NonFiction extends Book{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String categ;
	NonFiction nf;

	@Override
	public void readBook(Scanner sc) {
		System.out.println("1. Science\n2. Biography\n3. History");
		System.out.print(":: ");
		categ = sc.next();
			switch(categ) {
			case "1":
			case "Science":
				categ = "Science";
				nf = new Science();
				break;
			case "2":
			case "Biography":
				categ = "Biography";
				nf = new Biography();
				break;
			case "3":
			case "History":
				categ = "History";
				nf = new History();
			default:
				System.out.println("Wrong type! Try again");
//				continue;
			} //switch-case end
			nf.readBook(sc);
	} //read end

//	@Override
	void print() {
		System.out.printf(" %10s", categ);
	} //print end
} //NonFiction class end
