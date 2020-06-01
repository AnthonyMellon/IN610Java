package passignmentoneanthonymellon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Worker {
	
	private static Scanner sc;	
	
	public Worker()
	{
	}
	
	public static void loadSongs(ArrayList<Song> songs)
	{
		String decade;
		int position;
		String artist;
		String songTitle;
		double indicativeRevenue;
		String line;
		
		try
		{
			sc = new Scanner(new File("TopMusic.csv"));
			
			while (sc.hasNextLine() == true)
			{	
				line = sc.nextLine();
				String[] fields = line.split(",");
				decade = fields[0];			
				position = Integer.parseInt(fields[1]);
				artist = fields[2];
				songTitle = fields[3];
				indicativeRevenue = Double.parseDouble(fields[4]);	
				
				songs.add(new Song(decade, position, artist, songTitle, indicativeRevenue));
			}
			sc.close();
		}
		catch (IOException e)
		{
			System.out.println("File issues");
		}
	}
	
}
