package CollegeSystem;

import java.util.Scanner;

public interface Policies { //only some classes need this
	public final int maxMarks = 100;
	public final double maxGpa = 4.0;
	public void calculateGpa(Double...m);
}
