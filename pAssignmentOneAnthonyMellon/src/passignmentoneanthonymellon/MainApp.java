package passignmentoneanthonymellon;

import java.util.ArrayList;

public class MainApp {
	
	public static void main(String[] args) {

		ArrayList<Song> songList = new ArrayList<Song>(); 
				
		Worker.loadSongs(songList);
		
		for(Song song:songList)
		{
			System.out.println(song.toString());
		}
		
	}

}
