package Library;

import java.util.Scanner;

/**
 * {@summary }
 * 
 *
 */
public class Biography extends NonFiction{
	String title;
	Biography(Scanner sc){
		super(sc);
		System.out.print("Title: ");
		title = sc.nextLine();
	}
}
