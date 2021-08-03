package Library;

import java.util.Scanner;

public class Fiction extends Book{
	int categ;
	Fiction(Scanner sc){
		System.out.println("1. Comic\n2. Fantasy");
		categ = sc.nextInt();
		while(true) {
			switch(categ) {
			case 1:
				new Comic(sc);
				break;
			case 2:
				new Fantasy(sc);
				break;
			default:
				System.out.println("Wrong type! Try again");
				continue;	
			} //switch-case end
		} //while end
	} //Fiction end
}
