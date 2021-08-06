package Library;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary Member class : implements Policies, get member's information}
 * 
 *
 */
public class Member extends User implements Policies, Serializable{
	/**
	 * serial id for object writing
	 */
	private static final long serialVersionUID = 1L;
	String id; //member's id
	int age;
	int overdue;
	int totalFine;
	static int bookTotal;
	
	Member() {}
	
	@Override
	void read(Scanner sc) {
		super.PersonInfo(sc);
		System.out.print("What is your member id?: ");
		id = sc.next();
		System.out.print("What is your age?: ");
		age = sc.nextInt();

		System.out.print("How many books did you borrow?: ");
		bookTotal = sc.nextInt();
		Book.readBook(sc);
		whenIsDueDate(sc, bookTotal);		
	} //readMember end
	
	public static int getBookTotal() {return bookTotal;}
	
	@Override
	void print() {
		super.print();
		System.out.printf(" %9s | %5d | %2d days | $%3d |\n", id, getBookTotal(), overdue, totalFine); //fix book total copy to book class somewhr
	} //print end
	
	@Override
	public void whenIsDueDate(Scanner sc, int bookTotal) {
		System.out.print("How many days passed since borrowed? ");
		int days = sc.nextInt();
		overdue = days-due;
		if(overdue<=14) {
			System.out.printf("Overdue : %d day(s).\n", overdue);
		}
		howMuchFine(overdue, bookTotal);
	} //whenIsDueDate end

	@Override
	public void howMuchFine(int overdue, int bookTotal) {
		totalFine = overdue*fine*bookTotal; //total fine
		System.out.printf("Too late. Your fine will be $ %d \n", totalFine);
	} //howMuchFine end
	
	void writeMemberFile(ArrayList<Member> memberArr) { //writing new object to file
		try {
			FileOutputStream output = new FileOutputStream("member.lib");
			ObjectOutputStream objectOutput = new ObjectOutputStream(output);
			
			objectOutput.writeObject(memberArr);
			
			output.close();
			objectOutput.close();
		} catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.err.println("Error writing file");
		} //try-catch end
	} //writeMemberFile end
	
}//Member class end
