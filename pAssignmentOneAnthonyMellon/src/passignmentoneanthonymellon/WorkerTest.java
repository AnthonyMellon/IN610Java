package passignmentoneanthonymellon;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WorkerTest {

private ArrayList<Song> testSongs = new ArrayList<Song>();	
	
	@BeforeAll
	void setup()
	{
		testSongs.add(new Song("2000s", 1, "Anthony1", "Anthony1Song1", 191.91));
		testSongs.add(new Song("2000s", 2, "Anthony2", "Anthony2Song1", 190.90));
		testSongs.add(new Song("2000s", 3, "Anthony3", "Anthony3Song1", 180.80));
		testSongs.add(new Song("2000s", 4, "Anthony4", "Anthony4Song1", 170.70));
		testSongs.add(new Song("2000s", 5, "Anthony1", "Anthony1Song2", 160.60));
		testSongs.add(new Song("2000s", 6, "Anthony2", "Anthony2Song2", 150.50));
		testSongs.add(new Song("2000s", 7, "Anthony3", "Anthony3Song2", 140.40));
		testSongs.add(new Song("2000s", 8, "Anthony4", "Anthony4Song2", 140.40));
		testSongs.add(new Song("2000s", 9, "Anthony1", "Anthony1Song3", 130.30));
		testSongs.add(new Song("2000s", 10, "Anthony2", "Anthony2Song3", 120.20));
		testSongs.add(new Song("2000s", 11, "Anthony3", "Anthony3Song3", 110.10));
		testSongs.add(new Song("2000s", 12, "Anthony4", "Anthony4Song3", 100.00));
	}
	
	@Test
	void testMaxRev() {
		String expected = "191.91";
		String actual = Worker.FindMaxRev(testSongs);
		assertEquals(expected, actual);
	}
	
	@Test
	void testMinRev()
	{
		String expected = "100.00";
		String actual = Worker.FindMinRev(testSongs);
		assertEquals(expected, actual);
	}
	
	@Test
	void testMedRev()
	{
		String expected = "150.50";
		String actual = Worker.FindMedianRev(testSongs);
		assertEquals(expected, actual);
	}
	
	@Test
	void testMeanRev()
	{
		String expected = "148.91";
		String actual = Worker.FindMeanRev(testSongs);
		assertEquals(expected, actual);
	}
}
