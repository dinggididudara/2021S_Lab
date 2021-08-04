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
	
	Fiction(Scanner sc){
		System.out.println("1. Comic\n2. Fantasy");
		categ = sc.next();
		while(true) {
			switch(categ) {
			case "1":
			case "Comic":
				new Comic(sc);
				break;
			case "2":	
			case "Fantasy":
				new Fantasy(sc);
				break;
			default:
				System.out.println("Wrong type! Try again");
				continue;	
			} //switch-case end
		} //while end
	} //Fiction end
}
