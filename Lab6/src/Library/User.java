package Library;

import java.util.Scanner;

public class User extends Person{
	
	int type;
	
	void readUser(Scanner sc) {
		while(true) {
			System.out.print("1. Staff    2. Member\nAre you Staff or Member?: ");
			type = sc.nextInt();
			switch(type) {
			case 1:
				Staff s = new Staff();
				s.readStaff(sc);
				break;
			case 2:
				Member m = new Member();
				m.readMember(sc);
				break;
			default:
				System.out.println("Wrong type, please try again.");
				continue;
			} //switch-case end
		} //while end
	} //User end

}
