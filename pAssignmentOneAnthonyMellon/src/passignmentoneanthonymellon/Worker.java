package passignmentoneanthonymellon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Worker {

	private int nColumnsTotal;
	private int nColumnsWanted;
	
	private ArrayList<String> dataList;
	private Scanner sc;	
	
	public Worker()
	{
		nColumnsTotal = 11;
		nColumnsWanted = 5;		
		
		dataList = new ArrayList<String>();
		try
		{
			sc = new Scanner(new File("TopMusic.csv")).useDelimiter(",");	
		}
		catch (IOException e)
		{
			System.out.println("File issues");
		}
			
		
		while (sc.hasNextLine() == true)
		{
			dataList.add(sc.next());
		}
		sc.close();
		
		int currentColumn = 0;
		for(String data:dataList)
		{
			if(currentColumn < nColumnsWanted)
			{
				System.out.print(data);
			}			
			currentColumn ++;
			if(currentColumn >= nColumnsTotal)
			{
				System.out.println();
				currentColumn = 0;
			}
		}
	}
	
}
