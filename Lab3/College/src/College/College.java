package College;

import java.util.Scanner;

public class College {
	String name;
	Student[] students;
	Student s;
	
	College(String name, int num){
		this.name = name;
		students = new Student[num];
	}
	
	void printTitle() {
		System.out.printf("\n%s - List of Students\n", name);
		System.out.println("**********************************");
		System.out.println("Program|Student#|          Name|        Email|         Phone|  GPA|    Fees|   Credits|");
	}
	void readStudentsDetails(){
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<students.length;i++) {
			System.out.println("Enter details of student "+ (i+1) + ":");
			System.out.println("===================================");
			System.out.println("1 - Fulltime Student\n2 - Parttime Student");
			System.out.printf("Enter Student type: ");
			
			int type = sc.nextInt();
			
				if(type==1) {//for Fulltime Student
					students[i] = new FulltimeStudent();
				}else if(type==2) {//for Parttime Student
					students[i] = new ParttimeStudent();
				}else {
					System.out.println("Wrong student type");
				}
				students[i].readInfo();
			}
	}
	
	void printStudentsDetails() {		
		for(int i=0;i<students.length;i++) {
			students[i].printInfo();
		}
	}
}
