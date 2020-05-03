package pbox;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoxTest {

	private Box box;
	
	@Test
	void oneValueConstructor() {
		box = new Box(5);
		assertEquals(5, box.getHeight());
		assertEquals(5, box.getLength());
		assertEquals(5, box.getWidth());
	}
	
	@Test
	void twoValueConstructor()
	{
		box = new Box(5, 6);
		assertEquals(6, box.getHeight());
		assertEquals(5, box.getLength());
		assertEquals(5, box.getWidth());
	}

	@Test
	void threeValueConstructor()
	{
		box = new Box(5, 6, 7);
		assertEquals(5, box.getHeight());
		assertEquals(6, box.getWidth());
		assertEquals(7, box.getLength());
	}
	
	@Test
	void zeroSize()
	{
		box = new Box(0);
		assertEquals(0, box.calcVolume());
		assertEquals(0, box.calcSurfaceArea());
	}
	
	@Test
	void stringTest()
	{
		box = new Box(5);
		assertEquals("The height is: 5.0. The width is: 5.0. The length is: 5.0. The volume is: 125.0. The surface area is: 150.0.", box.toString());
	}
	
}
