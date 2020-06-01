package passignmentoneanthonymellon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author Anthony Mellon
 *
 */
public class Worker {
	
	private static Scanner sc;	
	private static int currentItem;
	
	public Worker()
	{
	}
	
	
	/**
	 * Load the songs into a given array list from the text file called 'TopMusic.csv'
	 * @param songs this is the given array list that the songs will be loaded into
	 */
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
	
	
	/**
	 * Draws the table
	 * @param tm the table model
	 * @param songList the 
	 */
	public static void drawTable(DefaultTableModel tm, ArrayList<Song> songList)
	{
		tm.setRowCount(0);
		for(Song song:songList)
		{			
			Object[] objects = new Object[4];
			objects[0] = song.getPosition();
			objects[1] = song.getArtist();
			objects[2] = song.getSongTitle();
			objects[3] = song.getIndicativeRevenue();

			tm.addRow(objects);
		}
	}
	
	/**
	 * Change the currently displayed song
	 * @param itemIndexChange the amount to change the song index by
	 * @param listSize the size of the array list of songs
	 */
	public static void changeItem(int itemIndexChange, int listSize)
	{
		currentItem += itemIndexChange;
		
		//Wrap the currentItem around so it doesn't fall off the edge of the songList array list
		if(currentItem > listSize - 1)
		{
			currentItem = 0;
		}
		else if(currentItem < 0)
		{
			currentItem = listSize - 1;
		}		
	}
	
	/**
	 * Change the currently displayed song to a specific song in the list
	 * Useful for displaying a searched song
	 * @param position the index of the song
	 * @param listSize the size of the array list of songs
	 */
	public static void changeItem(String position, int listSize)
	{	
		if(position == "First")
		{
			currentItem = 0;
		}
		else if(position == "Last")
		{
			currentItem = listSize - 1;
		}
	}
	
	/**
	 * update the labels to display information on the currently selected song
	 * @param songList the list of songs
	 * @param posLabel the label that will display the songs position
	 * @param artsitLabel the label that will display the songs artist
	 * @param titleLabel the label that will display the songs title
	 * @param revenueLabel the label that will display the songs indicative revenue
	 */
	public static void updateLabels(ArrayList<Song> songList, JLabel posLabel, JLabel artsitLabel, JLabel titleLabel, JLabel revenueLabel)
	{
		posLabel.setText(Integer.toString(songList.get(currentItem).getPosition()));
		artsitLabel.setText(songList.get(currentItem).getArtist());
		titleLabel.setText(songList.get(currentItem).getSongTitle());
		revenueLabel.setText(Double.toString(songList.get(currentItem).getIndicativeRevenue()));
	}
	
	/**
	 * Sort the list of songs on the songs positions
	 * @param songList the array list of songs
	 */
	public static void SortPosition(ArrayList<Song> songList)
	{
		Song temp;
		int i = 0;
		boolean sorted = false;
		
		while(sorted == false)
		{
			sorted = true;
			for(int j = 0; j < songList.size() - 1 - i; j++)
			{
				if(songList.get(j).getPosition() > songList.get(j+1).getPosition())
				{
					sorted = false;
					temp = songList.get(j);
					songList.set(j, songList.get(j+1));
					songList.set(j+1, temp);
				}
			}
			i++;			
		}
	}
	
	/**
	 * sort the list of songs on the songs artist
	 * @param songList the array list of songs
	 */
	public static void SortArtist(ArrayList<Song> songList)
	{
		Song temp;
		int i = 0;
		boolean sorted = false;
		
		while(sorted == false)
		{
			sorted = true;
			for(int j = 0; j < songList.size() - 1 - i; j++)
			{
				if(songList.get(j).getArtist().compareTo(songList.get(j+1).getArtist()) > 0)
				{
					sorted = false;
					temp = songList.get(j);
					songList.set(j, songList.get(j+1));
					songList.set(j+1, temp);
				}
			}
			i++;			
		}
	}
	
	/**
	 * sort the list of songs in the songs title
	 * @param songList the array list of songs
	 */
	public static void SortTitle(ArrayList<Song> songList)
	{
		Song temp;
		int i = 0;
		boolean sorted = false;
		
		while(sorted == false)
		{
			sorted = true;
			for(int j = 0; j < songList.size() - 1 - i; j++)
			{
				if(songList.get(j).getSongTitle().compareTo(songList.get(j+1).getSongTitle()) > 0)
				{
					sorted = false;
					temp = songList.get(j);
					songList.set(j, songList.get(j+1));
					songList.set(j+1, temp);
				}
			}
			i++;			
		}
	}
	
	/**
	 * sort the list of songs on the songs indicative revenue
	 * @param songList the array list of songs
	 */
	public static void SortRevenue(ArrayList<Song> songList)
	{
		Song temp;
		int i = 0;
		boolean sorted = false;
		
		while(sorted == false)
		{
			sorted = true;
			for(int j = 0; j < songList.size() - 1 - i; j++)
			{
				if(songList.get(j).getIndicativeRevenue() < songList.get(j+1).getIndicativeRevenue())
				{
					sorted = false;
					temp = songList.get(j);
					songList.set(j, songList.get(j+1));
					songList.set(j+1, temp);
				}
			}
			i++;			
		}
	}
	
	/**
	 * find the maximum indicative revenue in the list of songs
	 * @param songList the list of songs
	 * @return returns the max indicative revenue found as a string
	 */
	public static String FindMaxRev(ArrayList<Song> songList)
	{
		double max = songList.get(0).getIndicativeRevenue();
		for(Song song:songList)
		{
			if (song.getIndicativeRevenue() > max)
			{
				max = song.getIndicativeRevenue();
			}
		}
		
		return Double.toString(max);
	}
	
	/**
	 * find the minimum indicative revenue in the list of songs
	 * @param songList the list of songs
	 * @return returns the min indicative revenue found as a string
	 */
	public static String FindMinRev(ArrayList<Song> songList)
	{
		double min = songList.get(0).getIndicativeRevenue();
		for(Song song:songList)
		{
			if (song.getIndicativeRevenue() < min)
			{
				min = song.getIndicativeRevenue();
			}
		}
		
		return Double.toString(min);
	}
	
	/**
	 * find the mean indicative revenue in the list of songs
	 * @param songList the list of songs
	 * @return returns the mean indicative revenue as a string
	 */
	public static String FindMeanRev(ArrayList<Song> songList)
	{
		Double total = 0.0;
		for(Song song:songList)
		{
			total += song.getIndicativeRevenue();
		}
		Double mean = total/songList.size();
		return Double.toString(mean);
	}
	
	/**
	 * find the median indicative revenue in the list of songs
	 * @param songList the list of songs
	 * @return returns the median indicative revenue as a string
	 */
	public static String FindMedianRev(ArrayList<Song> songList)
	{
		SortRevenue(songList);
		double median = songList.get((songList.size()-1)/2).getIndicativeRevenue();
		return Double.toString(median);
	}
	
	/**
	 * search for a specific song using the songs title
	 * @param songList the list of songs
	 * @param target the songs title being looked for
	 */
	public static void Search(ArrayList<Song> songList, String target)
	{
		boolean found = false;
		
		for(Song song:songList)
		{
			if(song.getSongTitle().toLowerCase().compareTo(target.toLowerCase()) == 0)
			{
				found = true;
				currentItem = song.getPosition()-1;
			}
		}
		if(found == false)
		{
			JOptionPane.showMessageDialog(null, "Song not found");
		}
	}
	
	/**
	 * create a pie chart showing the indicative revenue of the top 10 ranked songs
	 * @param songList the list of songs
	 * @param tPane the tabbed pane the pie chart will be displayed on
	 */
	public static void createPieTop10(ArrayList<Song> songList, JTabbedPane tPane)
	{
		DefaultPieDataset data = new DefaultPieDataset();
		
		//Get the data
		for(int i = 0; i < 10; i++)
		{
			data.setValue(songList.get(i).getSongTitle(), songList.get(i).getIndicativeRevenue());
		}
		
		//create the chart
		JFreeChart chart = ChartFactory.createPieChart("Indicative Revenue of The Top 10 Songs", data, true, true, Locale.ENGLISH);
		
		//create and display a frame
		ChartPanel mypanel = new ChartPanel(chart);
		mypanel.setVisible(true);
		
		//add to tabbed pane
		tPane.add("Top 10 Pie Chart", mypanel);
	}
	
	/**
	 * create a pie chart showing the indicative revenue of the bottom 10 ranked songs
	 * @param songList the list of songs
	 * @param tPane the tabbed pane the pie chart will be displayed on
	 */
	public static void createPieBottom10(ArrayList<Song> songList, JTabbedPane tPane)
	{
		DefaultPieDataset data = new DefaultPieDataset();
		
		//create the data set
		for(int i = songList.size()-1; i > songList.size()-11; i--)
		{
			data.setValue(songList.get(i).getSongTitle(), songList.get(i).getIndicativeRevenue());
		}
		
		//create the chart
		JFreeChart chart = ChartFactory.createPieChart("Indicative Revenue of The Top 10 Songs", data, true, true, Locale.ENGLISH);
		
		//create and display a frame
		ChartPanel mypanel = new ChartPanel(chart);
		mypanel.setVisible(true);
		
		//add to tabbed pane
		tPane.add("Bottom 10 Pie chart", mypanel);
	}
	
	/**
	 * create a line chart showing a songs indicative revenue compared to its position
	 * @param songList the list of songs
	 * @param tPane the tabbed pane the line chart will be displayed on
	 */
	public static void createLineChart(ArrayList<Song> songList, JTabbedPane tPane)
	{
		//create the series
		XYSeries series1 = new XYSeries("Indicative Revenue and Song Position");
		for(Song song:songList)
		{
			series1.add(song.getPosition(), song.getIndicativeRevenue());
		}
		
		//create the data set
		XYSeriesCollection dataSet = new XYSeriesCollection();
		dataSet.addSeries(series1);
		
		JFreeChart chart = ChartFactory.createXYLineChart("Indicative Revenue On Song Position", "Song Revenue", "Indicitave Revenue", dataSet);
		
		//create and display frame
		ChartPanel mypanel = new ChartPanel(chart);
		mypanel.setVisible(true);
		
		//add to tabbed pane
		tPane.add("Line chart of all songs revenue", mypanel);
	}
}
