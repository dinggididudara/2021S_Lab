package Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class User extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Override
	void read(Scanner sc) {
		super.PersonInfo(sc);
	} //readUser end
	
	public String getName() {
		return fname + " " + lname;
	} //getName end
	
	void openStaffFile() { //open staff file
		try {			
			ArrayList<Staff> staffArr = new ArrayList<Staff>();
			FileInputStream inputStaff = new FileInputStream("staff.lib"); //open file
			ObjectInputStream objectInputStaff = new ObjectInputStream(inputStaff);
			
			staffArr.add((Staff)objectInputStaff.readObject()); //read objects
			
			if(!(staffArr.isEmpty())) {
				for(int i=0;i<staffArr.size();i++) {
//					staffArr.get(i).print();
					System.out.printf(" %s | %d | %s |\n", staffArr.get(i).getName(),staffArr.get(i).id, staffArr.get(i).section);
				}
			}else {
				System.err.println("Please read staffs from keyboard or file");
			} //if-else end
//			printDetailsStaff(staffArr);
			
			objectInputStaff.close();
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		}//try-catch end
	} //openFile end
	
	void openMemberFile() { //open member file
		try {		
			ArrayList<Member> memberArr = new ArrayList<Member>();
			FileInputStream inputStaff = new FileInputStream("member.lib");
			ObjectInputStream objectInputMember = new ObjectInputStream(inputStaff);
			
			memberArr.add((Member) objectInputMember.readObject());
			printDetailsMember(memberArr);

			if(!(memberArr.isEmpty())) {
				for(int i=0;i<memberArr.size();i++) {
					System.out.printf(" %s | %s |\n", memberArr.get(i).getName(), memberArr.get(i).id);
				}
			}else {
				System.err.println("Please read members from keyboard or file");
			} //if-else end
			
			objectInputMember.close();
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		} //try-catch end
	} //openFile end
	
	
	@Override
	void print() { //printing personal info
		System.out.printf(" %s |", getName());
	}
	
	static void printDetailsStaff(ArrayList<Staff> staffArr) {
		if(!(staffArr.isEmpty())) {
			for(int i=0;i<staffArr.size();i++) {
				staffArr.get(i).print();
			}
		}else {
			System.err.println("Please read staffs from keyboard or file");
		} //if-else end
	}//printDetails end
	
	static void printDetailsMember(ArrayList<Member> memberArr) {
		if(!(memberArr.isEmpty())) {
			for(int i=0;i<memberArr.size();i++) {
				memberArr.get(i).print();
			}
		}else {
			System.err.println("Please read members from keyboard or file");
		} //if-else end
	}//printDetails end
} //User class end
