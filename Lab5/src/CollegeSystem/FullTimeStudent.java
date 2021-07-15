package CollegeSystem;

public class FullTimeStudent extends Student{
	double tuition;
	
	FulltimeStudent(){}	
	@Override
	void readInfo() {
		super.readInfo();
		System.out.printf("Enter tuition fees: ");
		Scanner sc = new Scanner(System.in);
		tuitionFees = sc.nextDouble();
	}
	
	@Override
	void printInfo() {
		super.printInfo();
		System.out.printf("%8.2f|\n",tuitionFees);
		
	}
}
