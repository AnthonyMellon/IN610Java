package passignmentoneanthonymellon;

public class Song implements Comparable<Song>
{
	
	private String decade;
	private int position;
	private String artist;
	private String songTitle;
	private double indicativeRevenue;
	
	public Song(String decade, int position, String artist, String songTitle, double indicativeRevenue) {
		super();
		this.decade = decade;
		this.position = position;
		this.artist = artist;
		this.songTitle = songTitle;
		this.indicativeRevenue = indicativeRevenue;
	}

	public String getDecade() {
		return decade;
	}

	public void setDecade(String decade) {
		this.decade = decade;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public double getIndicativeRevenue() {
		return indicativeRevenue;
	}

	public void setIndicativeRevenue(double indicativeRevenue) {
		this.indicativeRevenue = indicativeRevenue;
	}

	@Override
	public String toString() {
		return "Song [decade: " + decade + ", position: " + position + ", artist: " + artist + ", songTitle: " + songTitle
				+ ", indicativeRevenue: " + indicativeRevenue + "]";
	}

	@Override
	public int compareTo(Song S1) 
	{
		//setting up the natural sort order		
		if(artist.equals(S1.getArtist()))
		{
			return songTitle.compareTo(S1.getSongTitle());
		}
		else
		{
			return artist.compareTo(S1.getArtist());
		}
		
	}
	
	
}
