package Library;

import java.io.Serializable;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public abstract class Book extends Library implements Serializable{
	/**
	 * serial id for object writer
	 */
	private static final long serialVersionUID = 7305354794360305675L;
	protected static int bookTotal;
	protected String categ;
	protected String title;
	protected String author;
	protected int year;
	
	Book(){}
	Book(String categ, String title, String author, int year){
		this.categ = categ;
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public static void readBook(Scanner sc) {
		Book b;
		System.out.print("How many books did you borrow?: ");
		bookTotal = sc.nextInt();
		for(int i=0;i<bookTotal;i++) { //add books
			if(bookTotal <= 5) {
				System.out.printf("information of book no.%d\n", (i+1));
				System.out.println("1. Fiction\n2. Non-fiction");
				System.out.print("Book's category?: ");
				int cate = sc.nextInt();
				switch(cate) {
				case 1:
					b = new Fiction();
					break;
				case 2:
					b = new NonFiction();
					break;
				default:
					System.out.println("Wrong type! Please try again.");
					continue;
				} //switch-case end
				b.read(sc);
				
				bookArr.add(b);
//				whenIsDueDate(sc, bookTotal); //calculate duedate
				writeBookFile(); //write objects to file
			}else if(bookTotal>5) { //if over maximum number of books
				System.out.println("over maximum. Try again.");
				continue;
			} //if-else end
		} //for end
	} //readUserBook
	
	public static int getBookTotal() {
		return bookTotal;
	}
		
	public void printt() {
		System.out.printf(" %s | %s | %s | %d |", categ, title, author, year);
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
	
	abstract void read(Scanner sc);
	abstract void print();
} //Book class end