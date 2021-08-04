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
	
	NonFiction(Scanner sc){
		System.out.println("1. Science\n2. Biography\n3. History");
		categ = sc.next();
		while(true) {
			switch(categ) {
			case "1":
			case "Science":
				new Science(sc);
				break;
			case "2":	
			case "Biography":
				new Biography(sc);
				break;
			case "3":	
			case "History":
				new History(sc);
			default:
				System.out.println("Wrong type! Try again");
				continue;	
			} //switch-case end
		} //while end
	}
}
