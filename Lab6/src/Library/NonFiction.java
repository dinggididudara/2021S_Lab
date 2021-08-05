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
	private static final long serialVersionUID = -1804399582950691688L;
	String categ;
	NonFiction nf;
	
	@Override
	void read(Scanner sc) {
		System.out.println("1. Science\n2. Biography\n3. History");
		System.out.print(":: ");
		categ = sc.next();
			switch(categ) {
			case "Science":
				nf = new Science();
				break;	
			case "Biography":
				nf = new Biography();
				break;
			case "History":
				nf = new History();
			default:
				System.out.println("Wrong type! Try again");
//				continue;
			} //switch-case end
			nf.read(sc);
	} //read end

	@Override
	void print() {
		System.out.printf(" %10s", categ);
	} //print end
} //NonFiction class end
