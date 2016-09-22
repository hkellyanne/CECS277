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


public class Geometric_Object_Tester {

	public static void main(String [] args) {
		//create an arraylist of type GeometricObject
		ArrayList<GeometricObject> go = new ArrayList<GeometricObject>();
		//add to array new objects
		go.add(new Circle("Blue", true, "round", 2.5));
		go.add(new Circle("Pink", false, "Pinky", 3));
		go.add(new Triangle("Orange", true, "pointy", 3, 6, 9));
		go.add(new Triangle("Red", false, "sharpie", 3.6, 7, 9.4));
		go.add(new Rectangle("Yellow", true, "four-eyes", 32, 4.5));
		go.add(new Rectangle("Purple", false, "purty", 3.98, 5.72)); 
		//add to array objects of same size
		go.add(new Circle("Blue", true, "circle twinsie1", 5));
		go.add(new Circle("Pink", false, "circle twinsie2", 5));
		go.add(new Triangle("Orange", true, "triangle twinsie1", 2.5, 6.0, 9.8));
		go.add(new Triangle("Red", false, "triangle twinsie2", 2.5, 6.0, 9.8));
		go.add(new Rectangle("Yellow", true, "rectangle twinsie1", 3.98, 6));
		go.add(new Rectangle("Purple", false, "rectangle twinsie2", 3.98, 6));   
		
		//comparing 2 shapes and returning the max
		System.out.println("Check which is Larger:");
		System.out.println(GeometricObject.Max(go.get(0), go.get(1)));
		System.out.println(GeometricObject.Max(go.get(2), go.get(3)));
		System.out.println(GeometricObject.Max(go.get(4), go.get(5)));
		System.out.println(GeometricObject.Max(go.get(6), go.get(7)));
		System.out.println(GeometricObject.Max(go.get(8), go.get(9)));
		System.out.println(GeometricObject.Max(go.get(10), go.get(11)));
		
		//sort array by area
		System.out.println("\n\nSorted by Area:");
		Collections.sort(go);
		
		for (int i=0;i<go.size();i++) {
			GeometricObject geo=go.get(i);
			System.out.println(geo);
			geo.getColor();
			geo.isFilled();
			geo.getDateCreated();
			geo.getName();
			
			//get methods of Circle
			if (geo instanceof Circle){
			   ((Circle)geo).getArea();
			   ((Circle)geo).getPerimeter();
			   ((Circle)geo).getDiameter();

			}
			//get methods of Triangle
			if(geo instanceof Triangle){
				((Triangle)geo).getArea();
				((Triangle)geo).getPerimeter();
			}
			//get methods of Rectangle
			if(geo instanceof Rectangle){
				((Rectangle)geo).getArea();
				((Rectangle)geo).getPerimeter();
			}
			

		
		}//end of for loop
		

		
		
		
	}//end of main


}