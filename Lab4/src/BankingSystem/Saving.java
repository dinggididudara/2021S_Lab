package BankingSystem;
/**
 * 
 * {@summary Saving class extends Account class.}
 *
 */
public class Saving extends Account{
	final double interestRate; 
	
	Saving(){ //initiating interest rate
		interestRate = 3.99; //yearly interest rate
		
	}
	@Override
	public void updateBalance() {
		balance = balance * (interestRate/1200+1);//calculate and add monthly interest
	}
}
