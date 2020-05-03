package pTemperature;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TempConvTest {

	private TempConv conv;
	
	@Test
	void testCelsius() {
		conv = new TempConv(0);
		conv.setCel(20);
		assertEquals(20, conv.getCel());
		assertEquals(68, conv.getFah());
		assertEquals(293.15, conv.getKel());
	}
	
	@Test
	void testCelsiusAgain()
	{
		conv = new TempConv(0);
		conv.setCel(17);
		assertEquals(17, conv.getCel());
		assertEquals(62.6, conv.getFah());
		assertEquals(290.15, conv.getKel());
	}
	
	@Test
	void testFahrenheit()
	{
		conv = new TempConv(0);
		conv.setFah(0);
		assertEquals(-17.78, conv.getCel(), 2);
		assertEquals(0, conv.getFah());
		assertEquals(255.37, conv.getKel(), 2);
	}
	
	@Test
	void testKelvin()
	{
		conv = new TempConv(0);
		conv.setKel(0);
		assertEquals(-273.15, conv.getCel());
		assertEquals(-459.67, conv.getFah(), 2);
		assertEquals(0, conv.getKel());		
	}
	
	@Test
	void testKelvinAgain()
	{
		conv = new TempConv(0);
		conv.setKel(456);
		assertEquals(182.85, conv.getCel(), 2);
		assertEquals(361.13, conv.getFah());
		assertEquals(456, conv.getKel());		
	}
	
	@Test
	void testToString()
	{
		
		conv = new TempConv(20);
		assertEquals("Celsius: 20.0 Fahrenheit: 68.0 Kelvin: 293.15", conv.toString());
	}
	
	@Test
	public void testGetCel2() {
		TempConv con = new TempConv(32);
		assertEquals(32, con.getCel(), 0.01);
	}

	@Test
	public void testGetFah2() {
		TempConv con = new TempConv(32);
		assertEquals((32 * 9.0 / 5) + 32, con.getFah(), 0.01);
	}

	@Test
	public void testGetKel2() {
		TempConv con = new TempConv(32);
		assertEquals((32 + 273.15), con.getKel(), 0.01);
	}

	@Test
	public void testSetCel2() {
		TempConv con = new TempConv(32);
		con.setCel(32);
		assertEquals(32, con.getCel(), 0.01);
	}

	@Test
	public void testSetFah2() {
		TempConv con = new TempConv(32);
		con.setFah(32);
		assertEquals(32, con.getFah(), 0.01);
	}

	@Test
	public void testSetKel2() {
		TempConv con = new TempConv(32);
		con.setKel(32);
		assertEquals(32, con.getKel(), 0.01);
	}

//	@Test
//	public void testToString2() {
//		TempConv con = new TempConv(32);
//		assertEquals("Celsius: 32.0 | Fahrenheit: 89.6 | Kelvin: 305.15", con.toString());
//	}


}
