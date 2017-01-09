/*
 * 1) Kelly Hall
 * 2) October 4, 2016
 * 3) compare 3 different objects using getMeasure() and Element T
 * 4) Input: N/A
 * 5) Output: the Largest measure and a sorted array by measure 
 */

package Generics;

public class Person<T> extends Measurable {
	String name = null;
	double height = 0.0;
	//constructor
	Person(String name, double height){
		this.name = name;
		this.height = height;
	}
	//get person's name
	public String getName(){
		return name;
	}
	@Override
	//get person's height
	public double getMeasure(){
	return height;
	}
	
	public String toString(){
		return height + " inches tall";
	}

}//end of person
