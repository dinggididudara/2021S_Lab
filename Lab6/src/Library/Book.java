package Library;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Book extends Library{ 
	
	void readUserBook(){
		
	} //readUserBook
	
	void openFile(Scanner sc) { //open file
		try {
			Path p = Paths.get("");
			sc = new Scanner(p);

			while(sc.hasNextLine()) { //if in the same line
				
			} //while end
		}catch(FileNotFoundException fe){
			System.err.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.err.println("Error opening file");
		} //try-catch end
	}
}
