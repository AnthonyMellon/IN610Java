package pfacebook;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class FaceBook {

	private ArrayList<Friend> friends;
	
	private String profile;
	
	public FaceBook(String profile)
	{
		friends = new ArrayList<Friend>();
		this.profile = profile;
	}
	
	public void addFriend(Friend newFriend)
	{
		boolean isNewFriend = true;
		
		for(Friend friend:friends)
		{
			if (friend.isTheSame(newFriend))
			{
				isNewFriend = false;
			}
		}
		
		if(isNewFriend == true)
		{
			friends.add(newFriend);
		}
		
	}
	
	public String toString()
	{
		StringBuilder data = new StringBuilder();
		
		for(Friend friend:friends)
		{
			data.append(friend.toString() + " ");
		}
		
		return data.toString();
	}
	
	public String agedLessThan21()
	{
		StringBuilder data = new StringBuilder();
		
		for(Friend friend:friends)
		{
			LocalDate now = LocalDate.now();
			
			long tweentyOne = ChronoUnit.DAYS.between(LocalDate.of(now.getYear() - 21, now.getMonth(), now.getDayOfMonth()), now);
			
			if(friend.calcAge() < tweentyOne)
			{
				
			}
		}
		
		return data.toString();
	}
	
	
	
}
