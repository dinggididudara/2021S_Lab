package Library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * {@summary Library class : printing users and books information}
 * 
 *
 */
public class Library implements Serializable{ //storing users and books info
	private static final long serialVersionUID = 1L;
	User u;
	static ArrayList<Staff> staffArr = new ArrayList<Staff>();
	static ArrayList<Member> memberArr = new ArrayList<Member>();
	/**
	 * {@summary readDetails method : read staff or member, and add to each array lists}
	 * @param sc Scanner
	 */
	void readDetails(Scanner sc) { //ask staff or member
		System.out.print("how many people will you write? ");
		int num = sc.nextInt();
		for(int i=0;i<num;i++) {
			System.out.print("1. Staff \n2. Member\nAre you Staff or Member?: ");
			int type = sc.nextInt();
			switch(type) {
			case 1: //if staff
				Staff s = new Staff();
				s.read(sc);
				staffArr.add(s);
				s.writeStaffFile(staffArr); //write objects to file
				break;
			case 2: //if member
				Member m = new Member();
				m.read(sc);
				memberArr.add(m);
				m.writeMemberFile(memberArr); //writ objects to file
				break;
			default:
				System.out.println("Wrong type, please try again.");
				continue;
			} //switch-case end
		} //while end
	} //readUser end
} //Library class end
