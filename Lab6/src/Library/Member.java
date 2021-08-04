package Library;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class Member extends User{
	/**
	 * serial id for object writing
	 */
	private static final long serialVersionUID = 7059470493805464799L;
	String id; //member's id
	int age;
	int bookTotal;
	static ArrayList<Book> bookArr; //list for books that member took
	
	Member() {}
	
	void readMember(Scanner sc) {
		super.readPerson(sc);
		System.out.print("What is your member id?: ");
		id = sc.next();
		System.out.print("What is your age?: ");
		age = sc.nextInt();
		
		Book.readUserBook(sc);
		
	} //readMember end
}//Member class end
