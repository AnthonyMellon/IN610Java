public class BankAccount {
	
	private double balance;
	
	public BankAccount()
	{
		balance = 0;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void deposit(int i)
	{
		balance += i;
	}
	
	public void withdraw(int i)
	{
		final double overdraftPenelty = 5; 
		
		balance -= i;
		if(balance < 0)
		{
			balance -= overdraftPenelty;
		}
	}
	
	public void addInterest()
	{
		if(balance > 0)
		{
			double interest = balance*0.05;
			double tax = interest*0.33;
			
			balance += (interest-tax);
		}				
	}
	
}
