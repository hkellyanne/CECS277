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
import java.lang.*;

public class Triangle extends GeometricObject{
	double a = 1.0;
	double b = 1.0;
	double c = 1.0;
	double area;
	double perimeter;
	String name;
	boolean filled;
	String color;
	java.util.Date dateCreated;
	
public Triangle(String color, boolean filled, String name, double side1, double side2, double side3){
	super(color, filled, name);
	this.name = name;
	dateCreated = new java.util.Date();
	this.color = color;
	this.filled = filled;
	this.a = side1;
	this.b = side2;
	this.c = side3;
}
//caluclate perimeter
public double getPerimeter(){
	perimeter = a + b + c;
	//System.out.println("perimeter = " + perimeter + "\n");
	return perimeter;
	
}
//calculate area
public double getArea(){
	double s = a + b + c;
	area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
	//System.out.println("Area = " + area);
	return area;
}
//convert to string
public String toString(){
	return "\n" + "I am named: " + name + " \n" + "Created on " + dateCreated + "\ncolor: " + color + " and filled: "+ filled;
}




}// end of Triangle