package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class Comic extends Fiction{
	String title;
	Comic(Scanner sc){
		System.out.print("Title: ");
		title = sc.nextLine();
	}
}
