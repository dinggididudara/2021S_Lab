package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class Member extends User{
	String id; //member's id
	int age;
	int bookNum;
	ArrayList<Book> list; //list for books that member took
	
	Member() {}
	
	void readMember(Scanner sc) {
		System.out.print("What is your member id?: ");
		id = sc.next();
		System.out.print("What is your age?: ");
		age = sc.nextInt();
		System.out.println("How many books did you borrow?: ");
		bookNum = sc.nextInt();
		for(int i=0;i<bookNum;i++) { //adding 
			System.out.printf("information of %d book", (i+1));
			System.out.print("book's category?: ");
			String cate = sc.next();
			System.out.print("book's title: ");
			String title = sc.next();
			
			list.add(new Book(cate,title)); //send book's info to Book class and add element to list
		}
	}
	
}//Member class end
