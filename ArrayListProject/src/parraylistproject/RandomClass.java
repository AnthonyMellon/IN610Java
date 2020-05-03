package parraylistproject;

import java.util.Random;

public class RandomClass {

	private int[] ranNums;
	
	public RandomClass(int number)
	{
		ranNums = new int[number];
	}
	
	public void fillNums()
	{
		Random rand = new Random();
		
		for(int i = 0; i < ranNums.length; i++)
		{
			ranNums[i] = rand.nextInt(101);	
		}
	}
	
	public String toString()
	{
		String message = "Numbers: \n";
		
		for(int number:ranNums)
		{
			message += Integer.toString(number) + "\n";
		}
		
		return message;
	}
	
}
