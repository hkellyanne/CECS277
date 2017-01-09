/*
 * 1) Kelly Hall
 * 2) October 4, 2016
 * 3) compare 3 different objects using getMeasure() and Element T
 * 4) Input: N/A
 * 5) Output: the Largest measure and a sorted array by measure 
 */


package Generics;

import java.util.ArrayList;


/**
Describes any class whose objects can be measured.
*/
public abstract class Measurable<T extends Comparable<? super T>> implements Comparable<Measurable <T>>
{	
	
	public static <T extends Measurable<T>> T Max (ArrayList<T> objects){
			T max = objects.get(0);
		   String maxstring = null;
		   String maxname = null;
		   
		      for (int i = 0; i < objects.size(); i++)
		      {
		    	  if(objects.get(i).getMeasure() > max.getMeasure()){
		    		  max = objects.get(i);
		    	  }	    	  
		      }
		      //return largest
		      return max;		
	}
	//compare object and return double
	public int compareTo(Measurable<T> otherObject){
		Measurable other = (Measurable) otherObject;
		return Double.compare(getMeasure(), other.getMeasure());
		
		
	}// end of compareTo
	

/**
   Computes the measure of the object.
   @return the measure
*/
abstract double getMeasure();
abstract String getName();




}//end of measurable