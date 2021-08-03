package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class Member extends User{
	String id; //member's id
	int age;
	int bookTotal;
	static ArrayList<Book> list; //list for books that member took
	
	Member() {}
	
	void readMember(Scanner sc) {
		System.out.print("What is your member id?: ");
		id = sc.next();
		System.out.print("What is your age?: ");
		age = sc.nextInt();
		System.out.println("How many books did you borrow?: ");
		bookTotal = sc.nextInt();
		for(int i=0;i<bookTotal;i++) { //adding 
			System.out.printf("information of %d book", (i+1));
			System.out.println("1. Fiction\n2. Non-fiction");
			System.out.print("book's category?: ");
			int cate = sc.nextInt();
			switch(cate) {
			case 1:
				new Fiction(sc);
				break;
			case 2:
				new NonFiction(sc);
				break;
			}
			System.out.print("book's title: ");
			String title = sc.next();
			
			list.add(new Book(sc)); //send book's info to Book class and add element to list
		}
	}
	
}//Member class end
