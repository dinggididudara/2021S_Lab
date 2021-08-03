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
	FileOutputStream  outputBook;
	ObjectOutputStream objectOutputBook;
	static ArrayList<Book> bookArr = new ArrayList<Book>();
	
	Book(){
		
	}
	Book(Scanner sc){
		
	}
	void readUserBook(){
		
	} //readUserBook
	
	@SuppressWarnings("unchecked")
	static void openBookFile() { //open book file
		try {
			FileInputStream inputBook = new FileInputStream("library.lib");
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
	
	void writeBookFile() { //writing new object to file
		try {
		outputBook = new FileOutputStream("book.lib");
		objectOutputBook = new ObjectOutputStream(outputBook);
		
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
}