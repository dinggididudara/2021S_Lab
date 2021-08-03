package Library;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class Member extends User{
	String id; //member's id
	int age;
	int bookTotal;
	static ArrayList<Book> bookArr; //list for books that member took
	
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
				Fiction f = new Fiction(sc);
				bookArr.add(i, f);
				break;
			case 2:
				NonFiction nf = new NonFiction(sc);
				bookArr.add(i, nf);
				break;
			} //switch-case end			
		} //for end
	} //readMember end
	
}//Member class end
