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
	protected String title;
	protected String author;
	protected int year;

	
	Book(){}
	static void readUserBook(Scanner sc){
		Book b;
		System.out.print("How many books did you borrow?: ");
		int bookTotal = sc.nextInt();
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
				bookArr.add(i,b);
				writeBookFile(bookArr);
			}else if(bookTotal>5) { //if over maximum number of books
				System.out.println("over maximum. Try again.");
				continue;
			} //if-else end
		} //for end
	} //readUserBook
	
	static void printBook() {
		if(!(bookArr.isEmpty())) {
			for(int i=0;i<bookArr.size();i++) {
				bookArr.get(i).print();;
			}
		} else {
			System.err.println("No book lists");
		}
	} //printBook end
	
	abstract void read(Scanner sc);
	abstract void print();
} //Book class end