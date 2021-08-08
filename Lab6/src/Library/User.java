package Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary User class : open member, staff file, print}
 * 
 *
 */
public class User extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	User(){} //initialize, empty it
	/**
	 * {@summary read method : reading personal information from super class (Person class)}
	 * @param sc Scanner
	 */
	@Override
	void read(Scanner sc) {
		super.PersonInfo(sc);
	} //readUser end
	/**
	 * {@summary getName method : getter for full name}
	 * @return fname + " " + lname : full name
	 */
	public String getName() {
		return fname + " " + lname;
	} //getName end
	/**
	 * {@summary openStaffFile method : open staff file (staff.lib) and add to staff array list}
	 */
	@SuppressWarnings("unchecked")
	static void openStaffFile() { //open staff file
		try {	
			ArrayList<Staff> staffArr = new ArrayList<Staff>();
			FileInputStream inputStaff = new FileInputStream("staff.lib"); //open file
			ObjectInputStream objectInputStaff = new ObjectInputStream(inputStaff);
			
			staffArr = (ArrayList<Staff>) objectInputStaff.readObject(); //read objects from file, add to array list

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
	/**
	 * {@summary openMemberFile method : open member file (member.lib) and add to member array list}
	 */
	@SuppressWarnings("unchecked")
	static void openMemberFile() { //open member file
		try {	
			ArrayList<Member> memberArr = new ArrayList<Member>();
			FileInputStream inputStaff = new FileInputStream("member.lib");
			ObjectInputStream objectInputMember = new ObjectInputStream(inputStaff);
			
			memberArr = (ArrayList<Member>) objectInputMember.readObject(); //read object from file, add to array list

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
	/**
	 * {@summary print method : override from Person class, print personal information, name, email, phone number}
	 */
	@Override
	void print() { //print personal information, common instance staff and member
		System.out.printf(" %14s | %11s | %12d |", getName(), email, phoneNumber);
	} //print end
} //User class end
