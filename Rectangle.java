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


public class Rectangle extends GeometricObject{
	
	String name;
	double area;
	double perimeter;
	double width = 1.0;
	double height = 1.0;
	

public Rectangle(String color, boolean filled, String name, double width, double height){	
	super(color, filled, name);
	this.name = name;
	this.width = width;
	this.height = height;

}
//calculate area
public double getArea(){
	area = width * height;
	//System.out.println("Area = " + area);
	return area;
}
//calculate Perimeter
public double getPerimeter(){
	perimeter = 2*(height + width);
	//System.out.println("Perimeter = " + perimeter + "\n");
	return perimeter;
}



}//end of Rectangle