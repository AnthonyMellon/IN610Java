package pfriends;

import java.util.ArrayList;

public class ArrayAndListUtilities {

	public static int findMax(int[] numbers)
	{
		int max = numbers[0];
		for(int number:numbers)
		{
			if (number > max)
			{
				max = number;
			}
		}
		return max;
	}
	
	public static int findMax(ArrayList<Integer>numbers)
	{
		int max = numbers.get(0);
		for(int number:numbers)
		{
			if (number > max)
			{
				max = number;
			}
		}
		return max;
	}
	
	public static int findMin(int[] numbers)
	{
		int min = numbers[0];
		for(int number:numbers)
		{
			if (number < min)
			{
				min = number;
			}
		}
		return min;
	}
	
	public static int findMin(ArrayList<Integer> numbers)
	{
		int min = numbers.get(0);
		for(int number:numbers)
		{
			if (number < min)
			{
				min = number;
			}
		}
		return min;
	}
	
	public static String findIt(int[] numbers, int wanted)
	{
		StringBuilder data = new StringBuilder("");
		boolean found = false;
		int count = 0;
		
		for(int number:numbers)
		{
			if(number == wanted)
			{
				found = true;
				data.append("Found " + number + " at position " + count + ". ");
			}
			
			count++;
		}
		if(found == false)
		{
			data.append("No numbers found");
		}
		
		return data.toString();
	}
	
	public static String findIt(ArrayList<Integer> numbers, int wanted)
	{
		StringBuilder data = new StringBuilder("");
		boolean found = false;
		int count = 0;
		
		for(int number:numbers)
		{
			if(number == wanted)
			{
				found = true;
				data.append("Found " + number + " at position " + count + ". ");
			}
			
			count++;
		}
		if(found == false)
		{
			data.append("No numbers found");
		}
		
		return data.toString();
	}
	
	public static void bubbleV1(int[] numbers)
	{
		int temp;
		
		for (int i = 0; i < numbers.length - 1; i++)
		{
			for(int j = 0; j < numbers.length - 1; j++)
			{
				if(numbers[j] > numbers[j+1])
				{
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
	}
	
	public static void bubbleV2(int[] numbers)
	{
		int temp;
		
		for(int i = 0; i < numbers.length - 1; i++)
		{
			for(int j = 0; j < numbers.length - 1 - i; j++)
			{
				if(numbers[j] > numbers[j+1])
				{
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
	}
	
	public static void bubbleV3(int[] numbers)
	{
		int temp;
		int i = 0;
		boolean sorted = false;
		
		while(sorted == false)
		{
			sorted = true;
			for(int j = 0; j < numbers.length - 1 - i; j++)
			{
				if(numbers[j] > numbers[j+1])
				{
					sorted = false;
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
			i++;			
		}
	}
	
	public static void selectV1(int[] numbers)
	{
		int smallestIndex = 0;
		int temp;
		
		for(int i = 0; i < numbers.length - 1; i++)
		{
			smallestIndex = i;
			for(int j = i; j < numbers.length - 1; j++)
			{
				if(numbers[smallestIndex] > numbers[j+1])
				{
					smallestIndex = j+1;
				}				
			}
			if(smallestIndex != i)
			{
				temp = numbers[i];
				numbers[i] = numbers[smallestIndex];
				numbers[smallestIndex] = temp;	
			}
			
			
		}
	}
	
	public static void bucketV1(int[] numbers)
	{
		int min = findMin(numbers);
		int max = findMax(numbers);
		int size = max - min;
		
		int[] bucket = new int[size+1];
		
		for(int i = 0; i < numbers.length; i++)
		{
			bucket[numbers[i] - min]++;
		}
		
		int i = 0;
		for(int b = 0; b < bucket.length; b++)
		{	
			
			for(int count = 0; count < bucket[b]; count++)
			{
				numbers[i] = b+min;
				i++;
			}
		}
	}
	
	public static int binarySeach(int[] numbers, int target)
	{
		bucketV1(numbers);
		int min = 0;
		int max = numbers.length-1;
		int middle;
		
		if(target > numbers[max] || target < numbers[min]) //If the target number isn't in the array
		{
			return -1;
		}
		
		boolean found = false;
		
		middle = (min+max)/2;
		
		while(found == false)
		{			
			if(target == numbers[middle])
			{
				found = true;
			}
			else if(target > numbers[middle])
			{
				min = middle+1;
			}
			else if(target < numbers[middle])
			{
				max = middle-1;
			}			
		}
		
		return middle;
		
	}
	
}