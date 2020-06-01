package passignmentoneanthonymellon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SongTest {

	private Song testSong = new Song("2000s", 1, "Anthony", "Anthonys Song", 100.00);
	
	@Test
	void testSetGetDecade() {
		testSong.setDecade("2010s");
		assertEquals("2010s", testSong.getDecade());
	}
	
	@Test
	void testSetGetArtist() {
		testSong.setArtist("coolAnthony");
		assertEquals("coolAnthony", testSong.getArtist());
	}
	
	@Test
	void testSetGetTitle() {
		testSong.setSongTitle("Anthonys Cool Song");
		assertEquals("Anthonys Cool Song", testSong.getSongTitle());
	}
	
	@Test
	void testSetGetRevenue() {
		testSong.setIndicativeRevenue(110.10);
		assertEquals(110.10, testSong.getIndicativeRevenue());
	}

}
