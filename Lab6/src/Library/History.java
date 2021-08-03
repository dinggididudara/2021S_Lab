package Library;

import java.util.Scanner;

public class History extends NonFiction{
	String title;
	History(Scanner sc){
		super(sc);
		System.out.print("Title: ");
		title = sc.nextLine();
	}
}
