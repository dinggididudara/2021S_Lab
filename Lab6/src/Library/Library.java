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
 * {@summary Library class : printing users and books information}
 * 
 *
 */
public class Library extends LibraryManagement implements Serializable{ //storing users and books info

	private static final long serialVersionUID = 6408272688595037091L;

	static ArrayList<Book> bookArr = new ArrayList<Book>();
	static ArrayList<Staff> staffArr = new ArrayList<Staff>();
	static ArrayList<Member> memberArr = new ArrayList<Member>();
	
	Library(){
		
	}
	static void readDetails(Scanner sc) { //ask staff or member
		System.out.print("how many people will you write? ");
		int num = sc.nextInt();
		for(int i=0;i<num;i++) {
			System.out.print("1. Staff \n2. Member\nAre you Staff or Member?: ");
			int type = sc.nextInt();
			switch(type) {
			case 1: //if staff
				Staff s = new Staff();
				s.readStaff(sc);
				staffArr.add(i,s);
				s.writeStaffFile(staffArr);
				break;
			case 2: //if member
				Member m = new Member();
				m.readMember(sc);
				memberArr.add(i,m);
				m.writeMemberFile(memberArr);
				break;
			default:
				System.out.println("Wrong type, please try again.");
				continue;
			} //switch-case end
		} //while end
	} //readUser end
	
	
	
	
	@SuppressWarnings("unchecked")
	static void openBookFile() { //open book file
		try {
			FileInputStream inputBook = new FileInputStream("src\\library.lib");
			ObjectInputStream objectInputBook = new ObjectInputStream(inputBook);
			
			bookArr = (ArrayList<Book>) objectInputBook.readObject();
						
			objectInputBook.close();
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		} //try-catch end
	} //openFile end
	
	static void writeBookFile() { //writing new object to file
		try {
			FileOutputStream outputBook = new FileOutputStream("src\\book.lib");
			ObjectOutputStream objectOutputBook = new ObjectOutputStream(outputBook);
		
			for(int i=0;i<bookArr.size();i++) {
				objectOutputBook.writeObject(bookArr.get(i));
			}
			
			outputBook.close();
		} catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.err.println("Error writing file");
		} //try-catch end
	} //writeBookFile end
} //Library class end
