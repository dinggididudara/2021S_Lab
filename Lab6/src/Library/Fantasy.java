package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class Fantasy extends Fiction{
	String title;
	Fantasy(Scanner sc){
		super(sc);
		System.out.print("Title: ");
		title = sc.nextLine();
	} //Fantasy end
} //Fantasy class end
