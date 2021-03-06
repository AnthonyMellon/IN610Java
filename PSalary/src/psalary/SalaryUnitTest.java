package psalary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SalaryUnitTest {

	Salary sal;
	
	@Test
	void gross100000()
	{
		sal = new Salary(100000);
		
		assertEquals(23920, sal.getTax());
	}
	
	@Test
	void gross50000()
	{
		sal = new Salary(50000);
		
		assertEquals(8020, sal.getTax());
	}
	
	@Test
	void gross20000()
	{
		sal = new Salary(20000);
		
		assertEquals(2520, sal.getTax());
	}
	
	@Test
	void gross5000()
	{
		sal = new Salary(5000);
		
		assertEquals(525, sal.getTax());
	}
	
	@Test
	void gross48000()
	{
		sal = new Salary(48000);
		
		assertEquals(7420, sal.getTax());
	}
	
	@Test
	void gross70000()
	{
		sal = new Salary(70000);
		
		assertEquals(14020, sal.getTax());
	}
	
	@Test
	void gross0()
	{
		sal = new Salary(0);
		
		assertEquals(0, sal.getTax());
	}
	
	@Test
	void grossNeg100()
	{
		sal = new Salary(-100);
		
		assertEquals(0, sal.getTax());
	}
	
	@Test
	void setGross()
	{
		sal = new Salary(100);
		sal.setGross(500);
		assertEquals(500, sal.getGross());
	}
	
	@Test
	void getGross()
	{
		sal = new Salary(500);
		assertEquals(500, sal.getGross());
	}
	
	@Test
	void getNet()
	{
		sal = new Salary(500);
		assertEquals(447.5, sal.getNet());
	}
	
//	@Test
//    public void dalesTestSuiteForTax()
//    {
//	//the instructor's test suite for tax
//	Salary money = new Salary(120000.50);
//	assertEquals(30520.17, money.getTax(),0.01);
//	money.setGross(52112);
//	assertEquals(8653.6, money.getTax(),0.01);
//	money.setGross(44567);
//	assertEquals(6819.23, money.getTax(),0.01);
//	money.setGross(7623);
//	assertEquals(800.42, money.getTax(),0.01);
//	//a couple more tests
//	//these would normally be in separate methods
//	//test the net
//	assertEquals(6822.59, money.getNet(),0.01);
//	//test a negative
//	money.setGross(-50);
//	assertEquals(0, money.getTax(),0.01);
//    }

}
