/*
 * 1) Kelly Hall
 * 2) September 14, 2016
 * 3) Create a Triangle, Circle and Rectangle class of Type Geometric Object, 
 * calculate area, perimeter, and diameter as needed,
 * and compare 2 shapes for the larger area
 * 4) Input: N/A
 * 5) Output: name, calculations, color, filled, date created, larger shape, sorted array 
 */



package GeometricObject;
import java.util.*;


//implements Comparable<GeometricObject>
public abstract class GeometricObject implements Comparable{
	private String color ="white";
	private boolean filled;
	private java.util.Date dateCreated;
	private String name = "noname";
	
	//construct a default geometric object
	public GeometricObject(){
		dateCreated = new java.util.Date();
	}
	
	//construct a default geometric object with the specific color and filled value
	public GeometricObject(String color, boolean filled, String name){
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
		this.name = name;
	}
	


	public int compareTo(Object otherObject){
		GeometricObject other = (GeometricObject) otherObject;
		return Double.compare(getArea(), other.getArea());
		
		
	}// end of compareTo
	

	
	public static Object Max(GeometricObject object1, GeometricObject object2){	
		
		if ((object1.compareTo(object2)) < 0){
			//System.out.println( object2.getName() + " is larger than " + object1.getName());	
			return object2.getName() + " is larger than " + object1.getName();
		}
		else if((object1.compareTo(object2)) > 0){
			//System.out.println( object1.getName() + " is larger than " + object2.getName());		
			return object1.getName() + " is larger than " + object2.getName();
		}
		else if((object1.compareTo(object2)) == 0){
			//System.out.println( object1.getName() + " and " + object2.getName() + " are the same size.");
			return object1.getName() + " and " + object2.getName() + " are the same size.";
		}
			return 0;
		
	
	    
	}//end of max
	

    

    
    
	//return color
	public String getColor(){
		return color;
	}
	
	//set new color
	public void setColor(String color){
		this.color = color;
	}
	
	//return filled
	public boolean isFilled(){
		return filled;
	}
	
	//set a new filled
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	//get date created
	public java.util.Date getDateCreated(){
		return dateCreated;
	}
	
	//return name
	public String getName(){
		return name;
	}
	
	//set a new name
	public void setName(String name){
		this.name = name;
	}
	
	//return a string representation of this object
	public String toString(){
		return "\n" + "I am named: " + name + " \n" + "Created on " + dateCreated + "\ncolor: " + color + " and filled: "+ filled;
	}
	
	abstract double getArea();
	abstract double getPerimeter();
	
}// end of Geometric Object
	
	
