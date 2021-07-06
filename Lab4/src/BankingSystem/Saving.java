package BankingSystem;

public class Saving extends Account{
	final double interestRate; 
	
	Saving(){ //initiating interest rate
		interestRate = 3.99; //yearly interest rate
		
	}
	@Override
	public void updateBalance() {
			balance = balance *(1+ Math.pow((1 + interestRate/100),1/12));//monthly interest adding
		}
}
