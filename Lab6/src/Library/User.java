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
	FileOutputStream  output;
	ObjectOutputStream objectOutput;
	FileInputStream inputStaff;
	ObjectInputStream objectInputMember;
	static ArrayList<Staff> staffArr = new ArrayList<Staff>();
	static ArrayList<Member> memberArr = new ArrayList<Member>();
	
	int type;
	
	void readUser(Scanner sc) {
		while(true) {
			System.out.print("1. Staff \n2. Member\nAre you Staff or Member?: ");
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
	} //readUser end
	
	@SuppressWarnings("unchecked")
	static void openStaffFile() { //open staff file
		try {			
			FileInputStream inputStaff = new FileInputStream("staff.lib");
			ObjectInputStream objectInputStaff = new ObjectInputStream(inputStaff);
			
			staffArr = (ArrayList<Staff>) objectInputStaff.readObject();

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
			FileInputStream inputStaff = new FileInputStream("member.lib");
			ObjectInputStream objectInputMember = new ObjectInputStream(inputStaff);
			
			staffArr = (ArrayList<Staff>) objectInputMember.readObject();

			objectInputMember.close();
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		} //try-catch end
	} //openFile end
	
	void writeStaffFile() { //writing new object to file
		try {
		output = new FileOutputStream("staff.lib");
		objectOutput = new ObjectOutputStream(output);
		
		
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
	
	void writeMemberFile() { //writing new object to file
		try {
		output = new FileOutputStream("member.lib");
		objectOutput = new ObjectOutputStream(output);
		
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
