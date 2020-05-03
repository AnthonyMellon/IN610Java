package parraylistproject;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ArrayListApp {

	
	
	public static void main(String[] args) {
		
		ArrayList<String> namesList = new ArrayList<String>();
		
		namesList.add("Anthony");
		namesList.add("Anthony Prime");
		namesList.add("God King Anthony");
		namesList.add("Supreme Leader Anthony");
		namesList.add("A̵̺͖͇̖̮͈̩̖̳͉̓̀̀͋͌͒̌͘͘͠ǹ̵̩͖͓̯̰͇͎̫̾̌̈́̓ţ̵̟̤̜̱̰̟̬̮̥̅̿̅̒͝h̸͖̳̭̓̊͘ō̴̳̰̭̻̪͐̈́̃͌̾͘̕͝n̴̰̫͎͖͖̤̥̈́̄̈́̿͑̂̚y̵͕̹͈̮̜̯̜̪̰̺͋̌͌͐́͐̃̚");
		
		System.out.println(namesList);
		
		namesList.remove(1);
		
		for(String name:namesList)
		{
			System.out.println(name);
		}
		
		int position = namesList.indexOf("Anthony");
		System.out.println(position);
		
		System.out.println(namesList.get(3));
		
		System.out.println("\n\n\n**********************************************************************\n\n\n");
		
		ArrayList<Balloon> balloons = new ArrayList<Balloon>();
		
		for(int i = 0; i < 10; i++)
		{
			balloons.add(new Balloon());	
		}
		
		for(Balloon balloon:balloons)
		{
			System.out.println(balloon.writeColour());
		}
		
		System.out.println("\n\n\n**********************************************************************\n\n\n");
		
		int amount = Integer.parseInt(JOptionPane.showInputDialog("How many random numbers do you want?"));
		
		RandomClass random = new RandomClass(amount);
		random.fillNums();
		
		System.out.println(random.toString());
		
	}

}
