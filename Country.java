/*
 * 1) Kelly Hall
 * 2) October 4, 2016
 * 3) compare 3 different objects using getMeasure() and Element T
 * 4) Input: N/A
 * 5) Output: the Largest measure and a sorted array by measure 
 */

package Generics;
import java.util.*;

public class Country<T> extends Measurable {
	String country = null;
	double area = 0.0;
	//country constructor
	Country(String country, double area){
		this.country = country;
		this.area = area;
	}
	//get country's name
	public String getName(){
		return country;
	}
	@Override
	//get country's area
	public double getMeasure(){
		return area;
	}
	public String toString(){
		return area + " miles squared";
	}
	

}//end of country
