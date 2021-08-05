package Library;

import java.util.Scanner;
/**
 * {@summary Member class : implements Policies, get member's information}
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
	
	Member() {}
	
	void readMember(Scanner sc) {
		System.out.print("What is your member id?: ");
		id = sc.next();
		System.out.print("What is your age?: ");
		age = sc.nextInt();
	} //readMember end
}//Member class end
