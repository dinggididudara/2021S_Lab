package Library;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public abstract class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String categ;	
	static ArrayList<Book> bookArr = new ArrayList<Book>();
	
	abstract void print(); //abstract method for sub classes
	abstract void readBooks(Scanner sc);
	
	public static void readBook(Scanner sc) {
		int bookTotal = Member.getBookTotal();
		for(int i=0;i<bookTotal;i++) { //add books
			if(bookTotal <= 5) {
				Book b;
				System.out.printf("information of book no.%d\n", (i+1));
				System.out.println("1. Fiction\n2. Non-fiction");
				System.out.print("Book's category?: ");
				int cate = sc.nextInt();
				switch(cate) {
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
//				bookArr.add(b);
				b.writeBookFile(bookArr); //write objects to file
			}else if(bookTotal>5) { //if over maximum number of books
				System.out.println("over maximum. Try again.");
				continue;
			} //if-else end
		} //for end
	} //readBook2 end
	
	void writeBookFile(ArrayList<Book> bookArr) { //writing new object to file
		try {
			FileOutputStream outputBook = new FileOutputStream("book.lib");
			ObjectOutputStream objectOutputBook = new ObjectOutputStream(outputBook);
		
			objectOutputBook.writeObject(bookArr);
			
			outputBook.close();
			objectOutputBook.close();
		} catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.err.println("Error writing file");
		} //try-catch end
	} //writeBookFile end	
} //Book class end