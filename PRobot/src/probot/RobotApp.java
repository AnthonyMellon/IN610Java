package probot;

public class RobotApp {

	public static void main(String[] args) {
		
		System.out.println("Making the robots");
		
		Robot machine1 = new Robot("r2d2", "the footpath");
		Robot machine2 = new Robot("c3p0", "the road");
		
		System.out.println(machine1.getName() + " runs on " + machine1.getFuel());
		System.out.println(machine2.getName() + " runs on " + machine2.getFuel());
		System.out.println("naughty " + machine2.getName());
	}

}
