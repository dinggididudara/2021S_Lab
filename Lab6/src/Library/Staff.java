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
	private static final long serialVersionUID = 6348620923416425668L;
	String id; //staff id
	int floor;
	String section;
	
	Staff(){}
	Staff(String id, int floor, String section){
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
	
	void printStaff() {
		System.out.printf("| %d | %s |\n", floor, section);
	}
	
	void writeStaffFile(ArrayList<Staff> staffArr) { //writing new object to file
		try {
			
			FileOutputStream output = new FileOutputStream("staff.lib");
			ObjectOutputStream objectOutput = new ObjectOutputStream(output);
		
			for(int i=0;i<staffArr.size();i++) {
				objectOutput.writeObject(new Staff(staffArr.get(i).id, staffArr.get(i).floor, staffArr.get(i).section));
			}
		
			output.close();
		} catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.err.println("Error writing file");
		} //try-catch end
	} //writeStaffFile end
}
