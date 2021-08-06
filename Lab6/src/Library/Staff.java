package Library;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class Staff extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	String id; //staff id
	int floor;
	String section;
	
	Staff(){}
	
//	Staff(String name, String id, int floor, String section){
//		super();
//		name = getName();
//		this.id = id;
//		this.floor = floor;
//		this.section = section;
//	}
	
	@Override
	void read(Scanner sc) { //reading staff's information from keyboard
		super.PersonInfo(sc);
		System.out.print("What is your staff id?: ");
		id = sc.next();
		System.out.print("floor?: ");
		floor = sc.nextInt();
		System.out.print("section?: ");
		section = sc.next();
	} //read end
	
	void writeStaffFile(ArrayList<Staff> staffArr) { //writing new object to file
		try {
			FileOutputStream output = new FileOutputStream("staff.lib"); //open file
			ObjectOutputStream objectOutput = new ObjectOutputStream(output);
		
			objectOutput.writeObject(staffArr); //write object to arraylist

			output.close();
			objectOutput.close();
		} catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.err.println("Error writing file");
		} //try-catch end
	} //writeStaffFile end
	
	@Override
	void print() {
		super.print();
		System.out.printf(" %5s | %5s |\n",id, section); //error
	}
}
