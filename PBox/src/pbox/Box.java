package pbox;

public class Box {

	private double height;
	private double width;
	private double length;
	
	public Box(double height, double width, double length)
	{
		setHeight(height);
		setWidth(width);
		setLength(length);
	}
	
	public Box(double squareBase, double height)
	{
		setHeight(height);
		setWidth(squareBase);
		setLength(squareBase);
	}
	
	public Box(double size)
	{
		setHeight(size);
		setWidth(size);
		setLength(size);
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getLength()
	{
		return length;
	}
	
	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public void setWidth(double width)
	{
		this.width = width;
	}
	
	public void setLength(double length)
	{
		this.length = length;
	}
	
	public double calcVolume()
	{
		return width*length*height;
	}
	
	public double calcSurfaceArea()
	{
		return (2*length*width) + (2*length*height) + (2*width*height);
	}
	
	public String toString()
	{
		return "The height is: " + height + ". The width is: " + width + ". The length is: " + length + ". The volume is: " + calcVolume() + ". The surface area is: " + calcSurfaceArea() + ".";
	}
	
}
