package panthonysdateextravaganza;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.JOptionPane;

public class AnthonysDateExtravaganzaApp {
	
	public static void main(String[] args)
	{
		LocalDate currentDate = LocalDate.now();
		LocalDateTime currentDateTime = LocalDateTime.now();
		
		System.out.println(currentDate);
		System.out.println(currentDate.getDayOfWeek());
		System.out.println(currentDate.getMonth());
		
		System.out.println(currentDate.getMonthValue());
		System.out.println(currentDate.getDayOfMonth());
		System.out.println(currentDate.getDayOfYear());
		System.out.println(currentDate.lengthOfMonth());
		System.out.println(currentDate.lengthOfYear());
		System.out.println(currentDateTime.getHour());
		System.out.println(currentDateTime.getMinute());
		System.out.println(currentDateTime.getSecond());
		
		System.out.println(currentDate.getDayOfWeek());
		
		System.out.println("******************************************************************");
		
		
		
		Instant raceStart = Instant.now();
		String birthDateString = JOptionPane.showInputDialog("Enter your birthdate please\nIn format dd/mm/yy");
		Instant raceEnd = Instant.now();
		
		long raceTime = Duration.between(raceStart, raceEnd).toMillis();
		
		
		String[] birthDateSplit = birthDateString.split("/", 3);		
		LocalDate birthDateLocal = LocalDate.of(Integer.parseInt(birthDateSplit[2]), Integer.parseInt(birthDateSplit[1]), Integer.parseInt(birthDateSplit[0]));
		
		int age = currentDate.getYear() - birthDateLocal.getYear();
		
		if(currentDate.getMonthValue() < birthDateLocal.getMonthValue())
		{
			age--;
		}
		else if(currentDate.getMonthValue() == birthDateLocal.getMonthValue())
		{
			if (currentDate.getDayOfMonth() < birthDateLocal.getDayOfMonth())
			{
				age--;
			}
		}
		
		System.out.println("Your age is: " + age);
		System.out.println("It took you " + Math.pow((double)raceTime, 1000)  + " seconds to enter your details.");
	}
	
}
