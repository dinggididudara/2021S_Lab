package Library;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class Staff extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id; //staff id
	int floor;
	String section;
	
	Staff(){}
	Staff(String name, String id, int floor, String section){
		name = getName();
		this.id = id;
		this.floor = floor;
		this.section = section;
	}

	void readStaff(Scanner sc) { //reading staff's information from keyboard
		super.PersonInfo(sc);
		System.out.print("What is your staff id?: ");
		id = sc.next();
		System.out.print("floor?: ");
		floor = sc.nextInt();
		System.out.print("section?: ");
		section = sc.next();
	}
	
//	public String getId() {return id;}
//	public String getSection() {return section;}
	
	void writeStaffFile(ArrayList<Staff> staffArr) { //writing new object to file
		try {
			FileOutputStream output = new FileOutputStream("staff.lib"); //open file
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
}
