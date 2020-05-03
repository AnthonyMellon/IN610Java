package pfriends;

public class friendsApp {

	public static void main(String[] args) {
		
		Friend firstFriend = new Friend("GodKing", "Anthony");
		Friend secondFriend = new Friend("Cool", "Dude", 1, 7, 2000);
		Friend thirdFriend = new Friend ("Random", "Guy", 5, 6, 2007, Gender.MALE, "Dunedin", "RandomGuy@emailAddress.com", Relationship.WIDOWED);
		
		System.out.println(firstFriend.toString());
		System.out.println(secondFriend.toString());
		System.out.println(thirdFriend.toString());
	}

}
