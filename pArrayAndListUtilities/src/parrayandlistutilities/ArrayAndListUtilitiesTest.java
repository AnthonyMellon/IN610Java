package parrayandlistutilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ArrayAndListUtilitiesTest {

	ArrayAndListUtilities temp = new ArrayAndListUtilities();
	
	int[] numbers = new int[] {60, 5, 70, 5, 52, 11, 12, 8, 19, 20};
	
	static ArrayList<Integer> numbersList = new ArrayList<Integer>();	
	
	@BeforeAll
	static void setup()
	{
		//numbersList.clear();
		numbersList.add(60);
		numbersList.add(5);
		numbersList.add(70);
		numbersList.add(5);
		numbersList.add(52);
		numbersList.add(11);
		numbersList.add(12);
		numbersList.add(8);
		numbersList.add(19);
		numbersList.add(20);
	}
	
	@Test
	void testSearchFor20Array() {
		
		String output = ArrayAndListUtilities.findIt(numbers, 20);
		
		assertEquals("Found 20 at position 9. ", output);
		
	}
	
	@Test
	void testSearchFor20List()
	{		
		String output = ArrayAndListUtilities.findIt(numbersList, 20);
		
		assertEquals("Found 20 at position 9. ", output);
	}
	
	@Test
	void testSearchForNothing()
	{
		String output = ArrayAndListUtilities.findIt(numbers, 0);
		
		assertEquals("No numbers found", output);
	}
	
	@Test
	void testSearchForNothingList()
	{
		String output = ArrayAndListUtilities.findIt(numbersList, 0);
		
		assertEquals("No numbers found", output);
	}
	
	@Test
	void testMax()
	{
		int expected = ArrayAndListUtilities.findMax(numbers);
		
		assertEquals(70, expected);
	}
	
	@Test
	void testMaxList()
	{
		int expected = ArrayAndListUtilities.findMax(numbersList);
		
		assertEquals(70, expected);
	}
	
	@Test
	void testMin()
	{
		int expected = ArrayAndListUtilities.findMin(numbers);
		
		assertEquals(5, expected);
	}
	
	@Test
	void testMinList()
	{
		int expected = ArrayAndListUtilities.findMin(numbersList);
		
		assertEquals(5, expected);
	}
	
	@Test
	void testBubbleV1() {
		
		int[] myNumbers = new int[] {5, 7, 1, 3, 8, 2};
		int[] myExpectedNumbers = new int[] {1, 2, 3, 5, 7, 8};
		ArrayAndListUtilities.bubbleV1(myNumbers);
		
		assertArrayEquals(myExpectedNumbers, myNumbers);
		
	}
	
	@Test
	void testBubbleV2() {
		
		int[] myNumbers = new int[] {5, 7, 1, 3, 8, 2};
		int[] myExpectedNumbers = new int[] {1, 2, 3, 5, 7, 8};
		ArrayAndListUtilities.bubbleV2(myNumbers);
		
		assertArrayEquals(myExpectedNumbers, myNumbers);
		
	}
	
	@Test
	void testBubbleV3() {
		
		int[] myNumbers = new int[] {5, 7, 1, 3, 8, 2};
		int[] myExpectedNumbers = new int[] {1, 2, 3, 5, 7, 8};
		ArrayAndListUtilities.bubbleV3(myNumbers);
		
		assertArrayEquals(myExpectedNumbers, myNumbers);
		
	}
	
	@Test
	void testSelectV1() {
		
		int[] myNumbers = new int[] {5, 7, 1, 3, 8, 2};
		int[] myExpectedNumbers = new int[] {1, 2, 3, 5, 7, 8};
		ArrayAndListUtilities.selectV1(myNumbers);
		
		assertArrayEquals(myExpectedNumbers, myNumbers);
		
	}
	
	@Test
	void testBucket() {
		
		int[] myNumbers = new int[] {5, -5, 7, 1, 3, 8, 2};
		int[] myExpectedNumbers = new int[] {-5, 1, 2, 3, 5, 7, 8};
		ArrayAndListUtilities.bucketV1(myNumbers);
		
		assertArrayEquals(myExpectedNumbers, myNumbers);
	}
	
	@Test
	void testBinarySearch() {
		
		int[] myNumbers = new int[] {1, 3, 5, 7, 8, 9, 10};
		int target = 5;
		int expectedIndex = 2;
		assertEquals(expectedIndex, ArrayAndListUtilities.binarySeach(myNumbers, target));
	}
}
