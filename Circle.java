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


public class Circle extends GeometricObject{
	String name;
	double radius = 1.0;
	double area;
	double perimeter;
	double diameter;
	
	
public Circle(String color, boolean filled, String name, double radius){	
	super(color, filled, name);
	this.radius = radius;
	this.name = name;


}

//calculate area
public double getArea(){
	area = (Math.PI * (radius * radius));
	//System.out.println("Area = " + area);
	return area;
}
//Calculate perimeter
public double getPerimeter(){
	perimeter = (2 * Math.PI * radius);
	//System.out.println("perimeter = " + perimeter);
	return perimeter;
	
}
//calculate Diameter
public double getDiameter(){
	diameter = (2 * radius);
	//System.out.println("diameter = " + diameter + "\n");
	return diameter;
	
}




}//end of Circle