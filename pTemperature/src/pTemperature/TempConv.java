package pTemperature;

public class TempConv {
	
	private double cel;
	private double fah;
	private double kel;
	
	public TempConv(double celsius)
	{
		setCel(celsius);		
	}
	
	public double getCel()
	{
		return cel;
	}
	
	public double getFah()
	{
		return fah;
	}
	
	public double getKel()
	{
		return kel;
	}
	
	public void setCel(double celsius)
	{
		cel = (celsius);
		fah = ((cel*9/5)+32);
		kel = (cel+273.15);
	}
	
	public void setFah(double fahrenheit)
	{
		fah = (fahrenheit);
		cel = ((fah-32)*5/9);
		kel = (cel+273.15);
	}
	
	public void setKel(double kelvin)
	{
		kel = (kelvin);
		cel = (kel-273.15);
		fah = ((cel*9/5)+32);
	}
	
	public String toString()
	{
		return("Celsius: " + cel + " Fahrenheit: " + fah + " Kelvin: " + kel);
	}
	
}
