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
 * {@summary Book class : ask user to input book lists}
 *  
 *
 */
public abstract class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String categ;	 //category, fiction or nonfiction
	static ArrayList<Book> bookArr = new ArrayList<Book>(); //for book lists
	
	abstract void print(); //abstract method for sub classes
	abstract void readBooks(Scanner sc); //abstract method for sub classes
	/**
	 * {@summary readBook method : reading book's information, Fiction or NonFiction}
	 * @param sc Scanner
	 */
	public static void readBook(Scanner sc) {
		int bookTotal = Member.getBookTotal();
		for(int i=0;i<bookTotal;i++) { //add books
			if(bookTotal <= 5) {
				Book b;
				System.out.printf("information of book no.%d\n", (i+1));
				System.out.println("1. Fiction\n2. Non-fiction");
				System.out.print("Book's category?: ");
				int categ = sc.nextInt();
				switch(categ) {
				case 1:
					b = new Fiction();;
					break;
				case 2:
					b = new NonFiction();
					break;
				default:
					System.out.println("Wrong type! Please try again.");
					continue;
				} //switch-case end
				b.readBooks(sc);
			}else if(bookTotal>5) { //if over maximum number of books
				System.out.println("over maximum. Try again.");
				continue;
			} //if-else end
		} //for end
	} //readBook2 end
	/**
	 * {@summary openBookFile method : open book file (book.lib) and print to console}
	 */
	@SuppressWarnings("unchecked")
	static void openBookFile() { //open book file
		try {
			ArrayList<Book> bookArr = new ArrayList<Book>();
			FileInputStream inputBook = new FileInputStream("book.lib");
			ObjectInputStream objectInputBook = new ObjectInputStream(inputBook);
			
			bookArr = (ArrayList<Book>) objectInputBook.readObject();
			
			if(!(bookArr.isEmpty())) {
				for(int i=0;i<bookArr.size();i++) {
					bookArr.get(i).print(); //print book's information
				}
			} else {
				System.err.println("No book lists");
			}
			
			inputBook.close();
			objectInputBook.close();
		}catch(FileNotFoundException fe){ //if file is not found
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		} //try-catch end
	} //openFile end
	/**
	 * {@summary writeBookFile method : write book lists which saved in bookArr to book list file (book.lib)}
	 * @param bookArr book lists' array list
	 */
	void writeBookFile(ArrayList<Book> bookArr) { //writing new object to file
		try {
			FileOutputStream outputBook = new FileOutputStream("book.lib");
			ObjectOutputStream objectOutputBook = new ObjectOutputStream(outputBook);
		
			objectOutputBook.writeObject(bookArr);
			
			outputBook.close();
			objectOutputBook.close();
		} catch(FileNotFoundException fe){ //if file is not found
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) { 
			System.err.println("Error writing file");
		} //try-catch end
	} //writeBookFile end	
} //Book class end