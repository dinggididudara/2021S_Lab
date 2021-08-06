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
public class Book implements Serializable{
	/**
	 * serial id for object writer
	 */
	private static final long serialVersionUID = 5959835822560038222L;
	protected String categ;
	protected String title;
	protected String author;
	protected int year;
	int bookTotal;
	
	static ArrayList<Book> bookArr = new ArrayList<Book>();
	
	Book(){}
	
	Book(String categ, String title, String author, int year){
		this.categ = categ;
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public void read(Scanner sc) {
		System.out.print("How many books did you borrow?: ");
		bookTotal = sc.nextInt();
		readBook(sc, bookTotal);
	} //read end
	
	public void readBook(Scanner sc, int bookTotal) {
		for(int i=0;i<bookTotal;i++) { //add books
			if(bookTotal <= 5) {
				Book b = new Book();
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
				b.read(sc);
				bookArr.add(i, b);
				writeBookFile(); //write objects to file
			}else if(bookTotal>5) { //if over maximum number of books
				System.out.println("over maximum. Try again.");
				continue;
			} //if-else end
		} //for end
	}
		
	public void printt() {
		System.out.printf(" %s | %s | %s | %d |\n", categ, title, author, year);
	}
	
	public static void printBook() { //printing book array
		if(!(bookArr.isEmpty())) {
			for(int i=0;i<bookArr.size();i++) {
				bookArr.get(i).printt();
			}
		} else {
			System.err.println("No book lists");
		}
	} //printBook end

	static void openBookFile() { //open book file
		try {
			FileInputStream inputBook = new FileInputStream("book.lib");
			ObjectInputStream objectInputBook = new ObjectInputStream(inputBook);
			
			bookArr.add((Book) objectInputBook.readObject());
			
			for(int i=0;i<bookArr.size();i++) { //print book lists
				bookArr.get(i).printt();
			}
		
			
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
			FileOutputStream outputBook = new FileOutputStream("book.lib");
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
//	abstract void read(Scanner sc);
//	abstract void print();
} //Book class end