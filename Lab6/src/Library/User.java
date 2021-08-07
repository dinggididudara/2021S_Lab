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
	
	User(){}
	User(String name){
		
	}
	
	@Override
	void read(Scanner sc) {
		super.PersonInfo(sc);
	} //readUser end
	
	public String getName() {
		return fname + " " + lname;
	} //getName end
	
	@SuppressWarnings("unchecked")
	static void openStaffFile() { //open staff file
		try {	
			ArrayList<Staff> staffArr = new ArrayList<Staff>();
			FileInputStream inputStaff = new FileInputStream("staff.lib"); //open file
			ObjectInputStream objectInputStaff = new ObjectInputStream(inputStaff);
			
			staffArr = (ArrayList<Staff>) objectInputStaff.readObject(); //read objects  

			if(!(staffArr.isEmpty())) {
				for(int i=0;i<staffArr.size();i++) {
					staffArr.get(i).print(); //print
				}
			}else {
				System.err.println("Please read staffs from keyboard or file");
			} //if-else end
			
			System.out.println("open file end"); //delete later
			inputStaff.close();
			objectInputStaff.close();
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		}//try-catch end
	} //openFile end
	
	@SuppressWarnings("unchecked")
	static void openMemberFile() { //open member file
		try {	
			ArrayList<Member> memberArr = new ArrayList<Member>();
			FileInputStream inputStaff = new FileInputStream("member.lib");
			ObjectInputStream objectInputMember = new ObjectInputStream(inputStaff);
			
			memberArr = (ArrayList<Member>) objectInputMember.readObject();

			if(!(memberArr.isEmpty())) {
				for(int i=0;i<memberArr.size();i++) {
					memberArr.get(i).print(); //print 
				}
			}else {
				System.err.println("Please read members from keyboard or file");
			} //if-else end
			
			inputStaff.close();
			objectInputMember.close();
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		} //try-catch end
	} //openFile end
	
	@Override
	void print() { //print personal information, common instance staff and member
		System.out.printf(" %14s | %11s | %12d |", getName(), email, phoneNumber);
	} //print end
} //User class end
