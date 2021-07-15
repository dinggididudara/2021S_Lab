package CollegeSystem;

public class College {
	String name;
	Student[] students;	
	Student s;
	
	College(String name, int num){
		this.name = name;
		students = new Student[num];
	}
	
	
	
	
	static public void printTitle() {
		for(int i=0;i<50;i++) {
			System.out.print("=");
		}
		System.out.println("");
	}
	
	static public void printDisplay() {
		printTitle();
		System.out.printf("%25s College - List of Students\n", Student.name);
		printTitle();
		System.out.printf("		Program|Student#|			Name|			Email|			Phone|	Gpa|	Fees|	Credits|");
	}
}
