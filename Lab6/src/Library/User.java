package Library;

import java.io.Serializable;
import java.util.Scanner;
/**
 * {@summary }
 * 
 *
 */
public class User extends Person implements Serializable{
	private static final long serialVersionUID = 5959835822560038222L;
	
	@Override
	void read(Scanner sc) {
		super.PersonInfo(sc);
	} //readUser end
	

	@Override
	void print() {
		System.out.printf(" %15s |", getName());
	}
} //User class end
