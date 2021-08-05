package Library;

import java.io.Serializable;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class Book extends Library implements Policies,Serializable{
	/**
	 * serial id for object writer
	 */
	private static final long serialVersionUID = 7305354794360305675L;
	protected String title;
	protected String author;
	protected int year;
	
	@Override
	void read(Scanner sc) {
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
				
				whenIsDueDate(sc, bookTotal); //calculate duedate
				writeBookFile(bookArr); //write objects to file
			}else if(bookTotal>5) { //if over maximum number of books
				System.out.println("over maximum. Try again.");
				continue;
			} //if-else end
		} //for end
	} //readUserBook
	
	@Override
	public void whenIsDueDate(Scanner sc, int bookTotal) {
		System.out.print("How many days passed since borrowed? ");
		int days = sc.nextInt();
		howMuchFine(days, bookTotal);		
	} //whenIsDueDate end

	@Override
	public void howMuchFine(int days, int bookTotal) {
		int overdue = days-due;
		if(days<=14) {
			System.out.printf("Your due is %d days left.\n", overdue);
		}else {
			for(int i=0;i<bookTotal;i++) {
				int totalFine = overdue*fine;
				System.out.printf("Too late. Your fine will be %d $\n", totalFine);
			} //for end
		}//if-else end
	} //howMuchFine end
	@Override
	void print() {
		if(!(bookArr.isEmpty())) {
			for(int i=0;i<bookArr.size();i++) {
				bookArr.get(i).print();
			}
		} else {
			System.err.println("No book lists");
		}
	} //printBook end
} //Book class end