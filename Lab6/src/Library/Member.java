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
	Member(String name, String id, int bookTotal, int overdue, int totalFine){
		name = getName();
		this.id = id;
		this.bookTotal = bookTotal;
		this.overdue = overdue;
		this.totalFine = totalFine;
	}
	
	void readMember(Scanner sc) {
		super.PersonInfo(sc);
		System.out.print("What is your member id?: ");
		id = sc.next();
		System.out.print("What is your age?: ");
		age = sc.nextInt();
		Book.read(sc);
		whenIsDueDate(sc,Book.getBookTotal());
	} //readMember end
	
	void printMember() {
		System.out.printf(" %s |", id);
	}
	
	@Override
	public int whenIsDueDate(Scanner sc, int bookTotal) {
		System.out.print("How many days passed since borrowed? ");
		int days = sc.nextInt();
		int overdue = days-due;
		howMuchFine(overdue, bookTotal);
		return overdue;
	} //whenIsDueDate end

	@Override
	public int howMuchFine(int overdue, int bookTotal) {
		int totalFine = overdue*fine;
		if(overdue<=14) {
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
				objectOutput.writeObject(new Member(memberArr.get(i).getName(), memberArr.get(i).id,memberArr.get(i).getBookTotal(), memberArr.get(i).totalFine));
			}
		
			output.close();
		} catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.err.println("Error writing file");
		} //try-catch end
	} //writeMemberFile end
	
}//Member class end
