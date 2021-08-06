package Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class User extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Override
	void readStaff(Scanner sc) {
		super.PersonInfo(sc);
	} //readUser end
	
	public String getName() {
		return fname + " " + lname;
	} //getName end
	
	void openStaffFile() { //open staff file
		try {			
			FileInputStream inputStaff = new FileInputStream("staff.lib"); //open file
			ObjectInputStream objectInputStaff = new ObjectInputStream(inputStaff);
			
			Library.staffArr.add((Staff)objectInputStaff.readObject()); //read objects
			
			if(!(Library.staffArr.isEmpty())) {
				for(int i=0;i<Library.staffArr.size();i++) {
					System.out.printf(" %s | %d | %s |\n", Library.staffArr.get(i).getName(),Library.staffArr.get(i).id, Library.staffArr.get(i).section);
				}
			}else {
				System.err.println("Please read staffs from keyboard or file");
			} //if-else end
			
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
//			ArrayList<Member> memberArr = new ArrayList<Member>();
			FileInputStream inputStaff = new FileInputStream("member.lib");
			ObjectInputStream objectInputMember = new ObjectInputStream(inputStaff);
			
			Library.memberArr.add((Member) objectInputMember.readObject());
//			printDetailsMember(memberArr);

			if(!(Library.memberArr.isEmpty())) {
				for(int i=0;i<Library.memberArr.size();i++) {
					System.out.printf(" %s | %s |\n", Library.memberArr.get(i).getName(), Library.memberArr.get(i).getId());
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
	void print() {
		// TODO Auto-generated method stub
		
	}
} //User class end
