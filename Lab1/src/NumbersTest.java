/*	CST8132 OOP
 *  Soomin Lee
 *  040899389   */

public class NumbersTest{
	
	public static void main(String[] args) {
		
		Numbers n1 = new Numbers(10);
		n1.generateNumbers();
		System.out.println("Printing Numbers");
		n1.printNumbers();	
		
		Numbers n2 = new Numbers(10,10);
		System.out.println("\n\nPrinting Positions");
		n2.printIndices();
		
		n2.generateSquares();
		
		System.out.println("\n\n\nPrinting Squares in a pattern");
		n2.printSquares();
		
		System.out.println("\n\n\nPrinting stars in Patterns");
		n2.printStarsPattern1();
		n2.printStarsPattern2();
	}//main end	
	
	static class Numbers{
		
		int[] numbers;
		
		int[][] squares;
		
		int i,j;
		//constructor 'numbers' w/ generateNumbers & printNumbers
			public Numbers(int size) {
				numbers=new int[size];
			}
			void generateNumbers() {
				for(i=0;i<numbers.length;i++){
					numbers[i]=i;
				}
			}
			void printNumbers() {
				for(i=0;i<numbers.length;i++){
					System.out.printf(numbers[i]+" ");
				}
			System.out.println("");
			}
			public Numbers(int row, int col) {
				squares=new int[row][col];
			}
		//methods printIndices & generateSquares & printSquares	
			void printIndices() {
				for (i=0;i<squares.length;i++) {
					for(j=0;j<squares[i].length;j++) {
						System.out.printf("%d,"+"%d ", i , j);
					}
					System.out.println("");
				}
			}
			
			void generateSquares() {
				for (i=0;i<squares.length-1;i++) {
					for(j=0;j<=i;j++) {
						squares[i][j] = (int) Math.pow(((i+1)*10)+j,2);
					}
				}
			}
			
			void printSquares() {
				for (i=0;i<squares.length-1;i++) {
					for(j=0;j<=i;j++) {
						System.out.printf("%4d"+" ",squares[i][j]);
					}
				System.out.println("");
				}
			}
		//methods printStarsPattern1 & 2	
			void printStarsPattern1() {
				for (i=0;i<squares.length;i++) {
					for(j=0;j<=i;j++) {
						System.out.printf("* ");
					}
				System.out.println("");
				}
			}
			void printStarsPattern2() {
				for (i=0;i<squares.length;i++) {
					for(j=squares[i].length-2-i;j>=0;j--) {
						System.out.printf("* ");
					}
				System.out.println("");
				}
			}
					
	}//Numbers end
	
}