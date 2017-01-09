/*
 * 1) Kelly Hall
 * 2) November 30, 2016
 * 3) input a number of animal contestents and have them race 100 paces.
 * 4) Input: number of contestents
 * 5) Output: Animals, their pace, laps, and place.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AnimalRace{


public static void main(String args[]){
	//initialize variables
	Thread thread;
	boolean check = true;
	int choice = 0;
	Scanner reader = new Scanner(System.in);
	PLACE place = new PLACE();
	
	//initialize arraylist
	ArrayList<Thread> allanimals = new ArrayList<Thread>();
	
	
	while(check){
	//ask user how many contestents will participate in the race
	System.out.println("How Many animals would you like to participate in the race? ");
	String input = reader.next();
	
	//verify the input is a valid integer
	try{	
		choice = Integer.valueOf(input);
		check = false;
	}
	catch(NumberFormatException exception){
		check = true;
	}
	}
	
	//add animals into array
	for (int i = 0; i < choice; i++){
		Thread runnable = new Animal(place);
		allanimals.add(runnable);
		
	}	
	
	//get contestents from arraylist
	for (int i = 0; i < choice; i++){
		allanimals.get(i).start();
	}	
	
	//wait for thread to die
	for (int i = 0; i < allanimals.size(); i++){
		try{
		allanimals.get(i).join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
//output that the race has ended
System.out.println("Race is Over!!");
}//end of Main
}//end of AnimalRace

