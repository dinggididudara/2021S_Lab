package BankingSystem;
/**
 * 
 * {@summary Checking class extends Account class}
 *
 */
public class Checking extends Account{
	final double fees;
	Checking(){ //initiating fee
		fees = 13.50;
	}
	@Override
	public void updateBalance(){//calculate balance
		balance = balance - fees;
	}
}
