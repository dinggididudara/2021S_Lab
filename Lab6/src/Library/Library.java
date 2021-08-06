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

	private static final long serialVersionUID = 5959835822560038222L;
	
	static ArrayList<Staff> staffArr = new ArrayList<Staff>();
	static ArrayList<Member> memberArr = new ArrayList<Member>();
	
	void read(Scanner sc) { //ask staff or member
		System.out.print("how many people will you write? ");
		int num = sc.nextInt();
		for(int i=0;i<num;i++) {
			System.out.print("1. Staff \n2. Member\nAre you Staff or Member?: ");
			int type = sc.nextInt();
			switch(type) {
			case 1: //if staff
				Staff s = new Staff();
				s.readStaff(sc);
				staffArr.add(s);
				s.writeStaffFile(staffArr);
				break;
			case 2: //if member
				Member m = new Member();
				m.readMember(sc);
				memberArr.add(m);
				m.writeMemberFile(memberArr);
				break;
			default:
				System.out.println("Wrong type, please try again.");
				continue;
			} //switch-case end
		} //while end
	} //readUser end
} //Library class end
