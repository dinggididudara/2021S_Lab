package Library;

import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class Fiction extends Book{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5728945184196674919L;
	String categ;
	Fiction f;

	@Override
	void read(Scanner sc) {
		System.out.println("1. Comic\n2. Fantasy");
		categ = sc.next();
			switch(categ) {
			case "1":
			case "Comic":
				categ = "Comic";
				f = new Comic();
				break;
			case "2":
			case "Fantasy":
				categ = "Fantasy";
				f = new Fantasy();
				break;
			default:
				System.out.println("Wrong type! Try again");
//				continue;
			} //switch-case end
			f.read(sc); 
	} //read end

	@Override
	void print() {
		System.out.printf(" %10s", categ);
		
	}
}
