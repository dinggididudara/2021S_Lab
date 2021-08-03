package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class NonFiction {
	int categ;
	NonFiction(Scanner sc){
		System.out.println("1. Science\n2. Biography\n3. History");
		categ = sc.nextInt();
		while(true) {
			switch(categ) {
			case 1:
				new Science(sc);
				break;
			case 2:
				new Biography(sc);
				break;
			case 3:
				new History(sc);
			default:
				System.out.println("Wrong type! Try again");
				continue;	
			} //switch-case end
		} //while end
	}
}
