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
	private static final long serialVersionUID = 5959835822560038222L;
	
	@Override
	void read(Scanner sc) {
		super.PersonInfo(sc);
	} //readUser end
	
	public String getName() {
		return fname + " " + lname;
	} //getName end
	
	@SuppressWarnings("unchecked") void openStaffFile() { //open staff file
		try {			
			ArrayList<Staff> staffArr = new ArrayList<Staff>();
			FileInputStream inputStaff = new FileInputStream("staff.lib");
			ObjectInputStream objectInputStaff = new ObjectInputStream(inputStaff);
			
			for(int i=0;i<staffArr.size();i++){
				staffArr = (ArrayList<Staff>) objectInputStaff.readObject();
			}
			printDetailsStaff(staffArr);
			objectInputStaff.close();
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		} //try-catch end
	} //openFile end
	
	@SuppressWarnings("unchecked") void openMemberFile() { //open member file
		try {		
			ArrayList<Member> memberArr = new ArrayList<Member>();
			FileInputStream inputStaff = new FileInputStream("src\\member.lib");
			ObjectInputStream objectInputMember = new ObjectInputStream(inputStaff);
			
			for(int i=0;i<memberArr.size();i++) {
				memberArr = (ArrayList<Member>) objectInputMember.readObject();
			}
			printDetailsMember(memberArr);
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
				staffArr.get(i).printStaff();
			}
		}else {
			System.err.println("Please read staffs from keyboard or file");
		} //if-else end
	}//printDetails end
	
	static void printDetailsMember(ArrayList<Member> memberArr) {
		if(!(memberArr.isEmpty())) {
			for(int i=0;i<memberArr.size();i++) {
				memberArr.get(i).printMember();
			}
		}else {
			System.err.println("Please read members from keyboard or file");
		} //if-else end
	}//printDetails end
} //User class end
