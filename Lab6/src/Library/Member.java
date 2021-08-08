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
	private static final long serialVersionUID = 1L; //for object writing, reading
	String id; //member's id
	int age;
	int overdue;
	int totalFine;
	static int bookTotal;
	
	Member() {} //initialize, empty it
	/**
	 * {@summary read method : override from User class, read personal info + member info}
	 * @param sc Scanner
	 * {@link #PersonInfo(Scanner)}
	 */
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
	
	public static int getBookTotal() {return bookTotal;} //saving book total (int)
	/**
	 * {@summary print method : override from User class, print member information}
	 * 
	 */
	@Override
	void print() {
		super.print();
		System.out.printf(" %9s | %5d | %2d days | $%3d |\n", id, getBookTotal(), overdue, totalFine); //fix book total copy to book class somewhr
	} //print end
	/**
	 * {@summary whenIsDueDate method : Override from Policies interface, reading how many days passed since borrowed, then calculate overdue and send to howMuchFine method}
	 * @param sc Scanner
	 * @param bookTotal total book numbers that member borrowed
	 * 
	 * {@link #howMuchFine(int, int)}
	 */
	@Override
	public void whenIsDueDate(Scanner sc, int bookTotal) {
		System.out.print("How many days passed since borrowed? ");
		int days = sc.nextInt();
		
		if(days>14) {
			overdue = days-due;
			System.out.printf("--Overdue : %d day(s).\n", overdue);
		} else {
			overdue = 0;
			System.out.printf("--Your due date: %d day(s) left. \n", (due-days));
		}
		howMuchFine(overdue, bookTotal);
	} //whenIsDueDate end
	/**
	 * {@summary howMuchFine method : Override from Policies interface, calculating fine}
	 * @param overdue overdue date from whenIsDueDate method
	 * @param bookTotal total book numbers that member borrowed
	 */
	@Override
	public void howMuchFine(int overdue, int bookTotal) {
		totalFine = overdue*fine*bookTotal; //total fine
		if(overdue != 0) {
			System.out.printf("--Too late. Your fine will be $ %d \n", totalFine);
		} else{
			totalFine = 0;
		}//if end
	} //howMuchFine end
	/**
	 * {@summary writeMemberFile method : write the member array list to member file(member.lib)}
	 * @param memberArr member array list
	 */
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
