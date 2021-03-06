import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTest {

	@Test
	void testGetBalance() {
		
		BankAccount acc = new BankAccount();
		assertEquals(0,acc.getBalance());
	}

	@Test
	void testDeposit() {
		
		BankAccount acc = new BankAccount();
		
		int amountToDeposit = 50;
		
		acc.deposit(amountToDeposit);
		assertEquals(amountToDeposit, acc.getBalance());
	}

	@Test
	void testWithdraw() {

		BankAccount acc = new BankAccount();
		
		int amountToWithdraw = 50;
		
		acc.withdraw(amountToWithdraw);
		assertEquals((amountToWithdraw*-1) - 5, acc.getBalance());
	}
	
	@Test
	void testWithdrawAndDeposit() {
		
		BankAccount acc = new BankAccount();
		
		acc.deposit(100);
		acc.withdraw(150);
		
		assertEquals(-55, acc.getBalance());
		
	}
	
	@Test
	void testAddInterest()
	{
		BankAccount acc = new BankAccount();
		
		acc.deposit(1000);
		acc.addInterest();
		
		assertEquals(1033.50, acc.getBalance());
	}

}
