/*
 * 1) Kelly Hall
 * 2) October 4, 2016
 * 3) compare 3 different objects using getMeasure() and Element T
 * 4) Input: N/A
 * 5) Output: the Largest measure and a sorted array by measure 
 */

package Generics;

import java.util.ArrayList;
import java.util.Collections;



public class MeasurableTester extends Measurable<MeasurableTester>{
	   //@SuppressWarnings("unchecked")
	public static void main(String[] args)
	   {
		   //create objects
		   BankAccount<Double> account1 = new BankAccount<Double>("Checkings", 135.00);
		   BankAccount<Double> account2 = new BankAccount<Double>("Savings", 1345.50);
		   Country<Integer> country1 = new Country<Integer>("Korea", 38691);
		   Country<Integer> country2 = new Country<Integer>("Japan", 145936);
		   Person<Integer> person1 = new Person<Integer>("Jimmy", 67);
		   Person<Integer> person2 = new Person<Integer>("Android", 3);
		   
		   //add objects to an array called objects
		   ArrayList<Measurable> objects = new ArrayList<Measurable>();
			  objects.add(account1);
			  objects.add(account2);
			  objects.add(country1);
			  objects.add(country2);
			  objects.add(person1);
			  objects.add(person2);
		   

			

		      System.out.println("The largest is: " + Max(objects).getName());
		      System.out.println(Max(objects).toString());

		      
		      //sort array by measurement
				System.out.println("\n\nSorted:");
				Collections.sort(objects);
		
			
			    for (int i = 0; i < objects.size(); i++){
			    	System.out.println(objects.get(i));
			    }	   
	   }

	@Override
	double getMeasure() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}//end of measurable tester
