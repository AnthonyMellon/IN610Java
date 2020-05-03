package pfriends;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

class FriendTest {

	private Friend firstFriend = new Friend("GodKing", "Anthony");
	private Friend secondFriend = new Friend("Cool", "Dude", 1, 7, 2000);
	private Friend thirdFriend = new Friend ("Random", "Guy", 5, 6, 2007, Gender.MALE, "Dunedin", "RandomGuy@emailAddress.com", Relationship.WIDOWED);
	
	@Test
	void testFirstName() {
		
		thirdFriend.setFirstName("Randomer");
		assertEquals("Randomer", thirdFriend.getFirstName());
	}
	
	@Test
	void testLastName() {
		
		thirdFriend.setLastName("Gal");
		assertEquals("Gal", thirdFriend.getLastName());
	}
	
	@Test
	void testBirthDate() {
		
		thirdFriend.setBirthDate(LocalDate.of(1774, 5, 3));
		assertEquals(LocalDate.of(1774, 5, 3), thirdFriend.getBirthDate());
	}
	
	@Test
	void testGender() {
		
		thirdFriend.setGender(Gender.FEMALE);
		assertEquals(Gender.FEMALE, thirdFriend.getGender());
	}
	
	@Test
	void testHomeTown() {
		
		thirdFriend.setHomeTown("BigCity");
		assertEquals("BigCity", thirdFriend.getHomeTown());
	}
	
	@Test
	void testEmail() {
		
		thirdFriend.setEmail("RandomerGal@emailAddress.com");
		assertEquals("RandomerGal@emailAddress.com", thirdFriend.getEmail());
	}
	
	@Test
	void testRelationshipStatus() {
		
		thirdFriend.setRelationship(Relationship.COMPLICATED);
		assertEquals(Relationship.COMPLICATED, thirdFriend.getRelationshipStatus());
	}
	
	@Test
	void testDateEntered() {
		assertEquals(LocalDate.now(), thirdFriend.getDateEntered());
	}
	
	@Test
	void testInvalidName()
	{
		firstFriend.setFirstName("a");
		assertEquals("GodKing", firstFriend.getFirstName());
	}
	
	@Test
	void testCalcAgeRegular()
	{
		LocalDate now = LocalDate.now();
		int age = (int)ChronoUnit.DAYS.between(LocalDate.of(2000, 7, 1), now);
		assertEquals(age, secondFriend.calcAge());
	}
	
	@Test
	void testCalcAgeBornToday()
	{
		secondFriend.setBirthDate(LocalDate.now());
		LocalDate now = LocalDate.now();
		assertEquals(0, secondFriend.calcAge());
	}
	
	@Test
	void testCalcAgeBornTomorrow()
	{
		LocalDate today = LocalDate.now();		
		secondFriend.setBirthDate(LocalDate.of(today.getYear(), today.getMonthValue(), today.getDayOfMonth() + 1));
		assertEquals(-1, secondFriend.calcAge());
	}
	
	@Test
	void testSamePersonTrue()
	{
		Friend testFriend = new Friend("Cool", "Dude", 2, 8, 2001);
		
		assertEquals(true, secondFriend.isTheSame(testFriend));
	}
	
	@Test
	void testSamePersonSameLastName()	
	{
		Friend testFriend = new Friend("Coolest", "Dude", 2, 8, 2001);
		assertEquals(false, secondFriend.isTheSame(testFriend));
	}
	
	@Test
	void testSamePersonSameFirstName()	
	{
		Friend testFriend = new Friend("Cool", "Guy", 2, 8, 2001);
		assertEquals(false, secondFriend.isTheSame(testFriend));
	}
	
	@Test
	void testToStringMinimum()
	{
		String expectedDetails = "GodKing Anthony. Date Added: 2020-03-10.";
		assertEquals(expectedDetails, firstFriend.toString());
	}
	
	@Test
	void testToStringMaximum()
	{
		String expectedDetails = "MR. Random Guy. Born: 5/6/2007. Gender: MALE. Home Town: Dunedin. Email: RandomGuy@emailAddress.com. Relationship Status: WIDOWED. Date Added: 2020-03-10.";
		assertEquals(expectedDetails, thirdFriend.toString());
	}
	
	@Test 
	void testToStringFemale()
	{
		thirdFriend.setGender(Gender.FEMALE);
		String expectedDetails = "MS. Random Guy. Born: 5/6/2007. Gender: FEMALE. Home Town: Dunedin. Email: RandomGuy@emailAddress.com. Relationship Status: WIDOWED. Date Added: 2020-03-10.";
		assertEquals(expectedDetails, thirdFriend.toString());
	}
	

}
