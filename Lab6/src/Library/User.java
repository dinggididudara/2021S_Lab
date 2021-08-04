package Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class User extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5959835822560038222L;
//	FileOutputStream  output;
//	ObjectOutputStream objectOutput;
//	FileInputStream inputStaff;
//	ObjectInputStream objectInputMember;
	
	static ArrayList<Staff> staffArr = new ArrayList<Staff>();
	static ArrayList<Member> memberArr = new ArrayList<Member>();
	
	User(){}
	static void readUser(Scanner sc) {
		System.out.print("how many people wil you write? ");
		int num = sc.nextInt();
		for(int i=0;i<num;i++) {
			System.out.print("1. Staff \n2. Member\nAre you Staff or Member?: ");
			int type = sc.nextInt();
			switch(type) {
			case 1:
				Staff s = new Staff();
				s.readStaff(sc);
				staffArr.add(i,s);
				writeStaffFile(staffArr.get(i));				
				break;
			case 2:
				Member m = new Member();
				m.readMember(sc);
				memberArr.add(i,m);
				writeMemberFile(memberArr.get(i));
				break;
			default:
				System.out.println("Wrong type, please try again.");
				continue;
			} //switch-case end
		} //while end
	} //readUser end
	
	@SuppressWarnings("unchecked")
	static void openStaffFile() { //open staff file
		try {			
			FileInputStream inputStaff = new FileInputStream("staff.lib");
			ObjectInputStream objectInputStaff = new ObjectInputStream(inputStaff);
			
			staffArr = (ArrayList<Staff>) objectInputStaff.readObject();
			
			for(int i=0;i<staffArr.size();i++) { //print staff file - staff.lib
				System.out.println(staffArr.get(i));
			}
			objectInputStaff.close();
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		} //try-catch end
	} //openFile end
	
	@SuppressWarnings("unchecked")
	static void openMemberfFile() { //open member file
		try {			
			FileInputStream inputStaff = new FileInputStream("src\\member.lib");
			ObjectInputStream objectInputMember = new ObjectInputStream(inputStaff);
			
			staffArr = (ArrayList<Staff>) objectInputMember.readObject();
			
			for(int i=0;i<staffArr.size();i++) { //print member file - member.lib
				System.out.println(staffArr.get(i));
			}
			objectInputMember.close();
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		} //try-catch end
	} //openFile end
	
	static void writeStaffFile(Staff staff) { //writing new object to file
		try {
			FileOutputStream output = new FileOutputStream("staff.lib");
			ObjectOutputStream objectOutput = new ObjectOutputStream(output);
		
			for(int i=0;i<staffArr.size();i++) {
				objectOutput.writeObject(staffArr.get(i));
			}
		
			output.close();
		} catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.err.println("Error writing file");
		} //try-catch end
	} //writeStaffFile end
	
	static void writeMemberFile(Member member) { //writing new object to file
		try {
			FileOutputStream output = new FileOutputStream("src\\member.lib");
			ObjectOutputStream objectOutput = new ObjectOutputStream(output);
		
			for(int i=0;i<memberArr.size();i++) {
				objectOutput.writeObject(memberArr.get(i));
			}
		
			output.close();
		} catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.err.println("Error writing file");
		} //try-catch end
	} //writeMemberFile end
}
