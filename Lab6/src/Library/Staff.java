package Library;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary Staff class : read staff information from user input}
 * 
 *
 */
public class Staff extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	String id; //staff id
	int floor;
	String section;
	
	Staff(){} //empty it, initialize
	/**
	 * {@summary read staff information , id, floor, section}
	 * @param sc Scanner
	 */
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
	/**
	 * {@summary writeStaffFile method : write staff array list to staff.lib}
	 * @param staffArr staff array list
	 */
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
	/**
	 * {@summary print method : override from person class, print id and section}
	 */
	@Override
	void print() {
		super.print();
		System.out.printf(" %8s | %7s |\n",id, section); //error
	}
}
