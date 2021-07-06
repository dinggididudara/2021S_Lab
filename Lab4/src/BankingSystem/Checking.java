package BankingSystem;

public class Checking extends Account{
	final double fees;
	Checking(){ //initiating fee
		fees = 13.50;
	}
	@Override
	public void updateBalance(){
		balance = balance - fees;
	}
}
