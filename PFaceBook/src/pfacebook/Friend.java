package pfacebook;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Friend {

	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private Gender gender;
	private String homeTown;
	private String email;
	private Relationship relationshipStatus;
	private LocalDate dateEntered;
	
	Friend(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		dateEntered = LocalDate.now();
	}
	
	Friend(String firstName, String lastName, int bDay, int bMonth, int bYear)
	{
		this(firstName, lastName);
		birthDate = LocalDate.of(bYear, bMonth, bDay);
	}
	
	Friend(String firstName, String lastName, int bDay, int bMonth, int bYear, Gender gender, String homeTown, String email, Relationship relationshipStatus)
	{
		this(firstName, lastName, bDay, bMonth, bYear);
		this.gender = gender;
		this.homeTown = homeTown;
		this.email = email;
		this.relationshipStatus = relationshipStatus;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public LocalDate getBirthDate()
	{
		return birthDate;	
	}
	
	public Gender getGender()
	{
		return gender;
	}
	
	public String getHomeTown()
	{
		return homeTown;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public Relationship getRelationshipStatus()
	{
		return relationshipStatus;
	}
	
	public LocalDate getDateEntered()
	{
		return dateEntered;
	}
	
	public void setFirstName(String newName)
	{
		if(isValidName(newName) == true)
		{
			firstName = newName;
		}		
	}
	
	public void setLastName(String newName)
	{
		lastName = newName;
	}
	
	public boolean isValidName(String name)
	{
		boolean validName = true;
		
		if(name.length() < 2)
		{
			validName = false;
		}
		
		return validName;
	}
	
	public void setBirthDate(LocalDate newDate)
	{
		birthDate = newDate;
	}
	
	public void setGender(Gender newGender)
	{
		gender = newGender;
	}
	
	public void setHomeTown(String newHomeTown)
	{
		homeTown = newHomeTown;
	}
	
	public void setEmail(String newEmail)
	{
		email = newEmail;
	}
	
	public void setRelationship(Relationship newRelationshipStatus)
	{
		relationshipStatus = newRelationshipStatus;
	}
	
	public int calcAge()
	{
		LocalDate now = LocalDate.now();
		
		long age = ChronoUnit.DAYS.between(birthDate, now);
		
		return (int)age;
	}
	
	public boolean isTheSame(Friend otherFriend)
	{
		boolean samePerson = false;
		
		if(getFirstName() == otherFriend.getFirstName() && getLastName() == otherFriend.getLastName())
		{
			samePerson = true;
		}
		
		return samePerson;
	}
	
	public String toString()
	{
		StringBuilder details = new StringBuilder(firstName + " " + lastName + ".");
		
		//Handling prefixes
		if(gender == Gender.MALE)
		{
			details.insert(0, "MR. ");
		}
		else if (gender == Gender.FEMALE)
		{
			details.insert(0, "MS. ");
		}
		
		//Handling birth date
		if(birthDate != null)
		{
			details.append(" Born: " + birthDate.getDayOfMonth() + "/" + birthDate.getMonthValue() + "/" + birthDate.getYear() + ".");
		}
		
		//Handling gender
		if(gender != null)
		{
			details.append(" Gender: " + gender + ".");
		}
		
		//Handling homeTown
		if(homeTown != null)
		{
			details.append(" Home Town: " + homeTown + ".");
		}
		
		//Handling email
		if(email != null)
		{
			details.append(" Email: " + email + ".");
		}
		
		//Handling relationship status
		if(relationshipStatus != null)
		{
			details.append(" Relationship Status: " + relationshipStatus + ".");
		}
		
		details.append(" Date Added: " + dateEntered + ".");
		
		return details.toString();
	}
	
	
}
