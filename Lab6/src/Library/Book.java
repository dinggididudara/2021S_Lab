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
 * {@summary }
 * 
 *
 */
public class Book extends Library implements Serializable{
	/**
	 * serial id for object writer
	 */
	private static final long serialVersionUID = 7305354794360305675L;
	FileOutputStream  outputBook;
	ObjectOutputStream objectOutputBook;
	String categ;
	String title;
	String author;
	int year;
	static ArrayList<Book> bookArr = new ArrayList<Book>();
	
	Book(){}
	static void readUserBook(Scanner sc){
		System.out.println("How many books did you borrow?: ");
		int bookTotal = sc.nextInt();
		for(int i=0;i<5;i++) { //add books
			if(bookTotal <= 5) {
				System.out.printf("information of %d book", (i+1));
				System.out.println("1. Fiction\n2. Non-fiction");
				System.out.print("Book's category?: ");
				int cate = sc.nextInt();
				switch(cate) {
				case 1:
					Fiction f = new Fiction(sc);
					bookArr.add(f);
					break;
				case 2:
					NonFiction nf = new NonFiction(sc);
					bookArr.add(nf);
					break;
				default:
					System.out.println("Wrong type! Please try again.");
					continue;
				} //switch-case end
			}else if(bookTotal>5) { //if over maximum number of books
				System.out.println("over maximum. Try again.");
				continue;
			} //if-else end
		} //for end
	} //readUserBook
	
	@SuppressWarnings("unchecked")
	static void openBookFile() { //open book file
		try {
//			Formatter formatter = new Formatter();
			FileInputStream inputBook = new FileInputStream("src\\library.lib");
			ObjectInputStream objectInputBook = new ObjectInputStream(inputBook);
			
			bookArr = (ArrayList<Book>) objectInputBook.readObject();
			for(int i=0;i<bookArr.size();i++) {
				System.out.println(bookArr.get(i));
				
			}
			objectInputBook.close();
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(ClassNotFoundException e) {
			
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		} //try-catch end
	} //openFile end
	
	void writeBookFile(ArrayList<Book> bookArr) { //writing new object to file
		try {
			outputBook = new FileOutputStream("book.lib");
			objectOutputBook = new ObjectOutputStream(outputBook);
//			Formatter formatter = new Formatter(objectOutputBook);
		
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
} //Book class end