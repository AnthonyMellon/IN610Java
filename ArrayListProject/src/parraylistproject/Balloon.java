package parraylistproject;

import java.util.Random;

public class Balloon {

	private int colour;
	
	public Balloon()
	{
		Random rand = new Random();
		colour = rand.nextInt(10)+1;		
	}
	
	public int getColour()
	{
		return colour;
	}
	
	public String writeColour()
	{
		switch(colour)
		{
			case 1:
				return "red";
			case 2:
				return "orange";
			case 3:
				return "yellow";
			case 4:
				return "green";
			case 5:
				return "blue";				
			case 6:
				return "pink";
			case 7:
				return "purple";
			case 8:
				return "balck";
			case 9:
				return "grey";
			case 10:
				return "white";
			default:
				return "unknown colour";
		}
	}
	
}
