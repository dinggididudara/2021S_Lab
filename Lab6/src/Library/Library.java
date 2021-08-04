package Library;

/**
 * {@summary Library class : printing users and books information}
 * 
 *
 */
public class Library{ //storing users and books info
	
	static void printMember() {
		for(int j=0;j<User.memberArr.size();j++) {
			System.out.printf("name : %s | number of books : %d | fine : %d", User.memberArr.get(j).getName(), User.memberArr.get(j).bookTotal, fine);
		}
	} //printUser end
	
	static void printStaff() {
		for(int i=0;i<User.staffArr.size();i++) {
			System.out.printf("name : %s | section : %s", User.staffArr.get(i).getName(), User.staffArr.get(i).section);
		}
	} //printStaff end
	
	void printBook() {
		for(int i=0;i<Book.bookArr.size();i++) {
			System.out.printf("title : %s| category : %s | author : %s", Book.bookArr.get(i).title, Book.bookArr.get(i).categ, Book.bookArr.get(i).author );
		} //for end
	}
}
