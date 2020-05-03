package pnameinstars;

import javax.swing.JOptionPane;

public class NameInStarsApp {

	public static void main(String[] args) {
		
		//get the users name
		String userName = JOptionPane.showInputDialog("Enter your name");
		
		//create a NameInStars object that stores the user name
		NameInStars you = new NameInStars(userName);
		
		//display the name
		JOptionPane.showMessageDialog(null, you.surroundNameInStars());

	}

}
