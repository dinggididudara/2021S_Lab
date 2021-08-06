package Library;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary Member class : implements Policies, get member's information}
 * 
 *
 */
public class Member extends User implements Policies{
	/**
	 * serial id for object writing
	 */
	private static final long serialVersionUID = 7059470493805464799L;
	String id; //member's id
	int age;
	
	Member() {}
	
	void readMember(Scanner sc) {
		super.PersonInfo(sc);
		System.out.print("What is your member id?: ");
		id = sc.next();
		System.out.print("What is your age?: ");
		age = sc.nextInt();
		Book.readBook(sc);
		whenIsDueDate(sc,Book.getBookTotal());
	} //readMember end
	
	void printMember() {
		System.out.printf(" %s |", id);
	}
	
	@Override
	public void whenIsDueDate(Scanner sc, int bookTotal) {
		System.out.print("How many days passed since borrowed? ");
		int days = sc.nextInt();
		howMuchFine(days, bookTotal);
	} //whenIsDueDate end

	@Override
	public int howMuchFine(int days, int bookTotal) {
		int overdue = days-due;
		int totalFine = overdue*fine;
		if(days<=14) {
			System.out.printf("Your due is %d days left.\n", overdue);
		}else {
			for(int i=0;i<bookTotal;i++) {
				
				System.out.printf("Too late. Your fine will be %d $\n", totalFine);
			} //for end
		}//if-else end
		return totalFine;
	} //howMuchFine end
	
	void writeMemberFile(ArrayList<Member> memberArr) { //writing new object to file
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
	
}//Member class end
