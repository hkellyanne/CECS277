/*
 * 1) Kelly Hall
 * 2) November 15, 2016
 * 3) Create a Scavenger Hunt of 100 items and calculate the time it takes to load, retrieve, insert and find a random index within a linkedlist and arraylist
 * 4) Input: Number of Scavenger groups, index number for retrieving and inserting
 * 5) Output: Groups and their lists of 100 itmes using linkedlist/arraylist, item retrieved from index, added item in each inputted index, random number, loading index at random number, total time each execution takes.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Part3Array {
	public static void main (String args[]){
		//initialize variables
		Scanner in = null;
		Scanner in2 = null;
		Scanner reader = new Scanner(System.in);
		int listChoice = 0;
		int teams = 0;
		int position = 0;
		boolean listBool = true;
		boolean teamBool = true;
		boolean posBool = true;
		
		//initialize variables needed to calculate runtime
		long load1, load2;
		long retrieve1, retrieve2;
		long insert1, insert2;
		long random1, random2;
		
		//initialize variables to test results
		int arrayload = 0;
		int arrayretrieve = 0;
		int arrayinsert = 0;
		int arrayrandom = 0;
		
		int linkedload = 0;
		int linkedretrieve = 0;
		int linkedinsert = 0;
		int linkedrandom = 0;
		
		
		
		//create List of Lists(array)
		List<List<String>> lists = new ArrayList<List<String>>();
		//create list
		List<String> teamList = new ArrayList<String>();

		
		//create List of Lists(linkedlist)
		List<List<String>> llists = new LinkedList<List<String>>();
		//create list
		List<String> lteamList = new LinkedList<String>();
		
		
		//initialize file
		File file = new File("randomitems.txt");
		
		//try reading file in
		try{
		in = new Scanner(file);
		in2 = new Scanner(file);
		
		//read into array
		while(in.hasNextLine()){
			teamList.add(in.nextLine());
		}
		
		//read into linkedlist
		while(in2.hasNextLine()){
			lteamList.add(in2.nextLine());
		}
		
		//print out complete list
		System.out.println("Scavenger Hunt (100 Items)");
		
		//ask user which type of list they would like to use
		while(listBool){
		System.out.println("Would you like your Scavenger Hunt List in an ArrayList or LinkedList?");
		System.out.println("1) ArrayList \n2) LinkedList");
		String input = reader.next();
		
		//test for valid input
		try{
		
		listChoice = Integer.valueOf(input);
		listBool = false;
		}
		catch(NumberFormatException exception){
			System.out.println("Please enter 1 or 2");
			listBool = true;
		}
		}
		
		}//end of try
		
		//if file is not found, catch
		catch(FileNotFoundException exception){
			System.out.println("File not found");
		}
		finally{
			in.close();
	
		}
		
		
		switch(listChoice){
		//case1: user has chosen to use array
		case 1:{
			
			//load array for each team
			while (teamBool){
				//test for valid input
				System.out.println("\nHow many teams would you like to form?");
				String inputGet = reader.next();
				try{
					teams = Integer.valueOf(inputGet);
					teamBool = false;
				} catch(NumberFormatException exception){
					teamBool = true;
				} 
			}
			load1 = System.nanoTime();
			//shuffle list and output list for each time
			for (int t = 0; t < teams; t++){
				
				Collections.shuffle(teamList);
				lists.add(new ArrayList<String>(teamList));
				System.out.println("\n TEAM " + (t+1) + ": ");
				for (int i = 0; i < teamList.size(); i++){
					System.out.print("[" + (i+1) + ". " + teamList.get(i) + "]");
				}
			}
			load2 = System.nanoTime();
			//calculate time to load lists for each time
			arrayload = (int) (load2 - load1);
			System.out.println("\nTime to load ArrayList is: " + (load2 - load1));
			
			//get position for retrieving and inserting elements
			while(posBool){
				System.out.println("\nWhat position would you like to use for retreiving and inserting?");
				String inputget2 = reader.next();
				//test for valid input
				try{
					position = Integer.valueOf(inputget2);
					posBool = false;
					
				}
				catch(NumberFormatException exception){
					posBool = true;
				}
			}
			
			retrieve1 = System.nanoTime();
			//retrieve item at user chosen position
			for(int j = 0; j < teams; j++){
				System.out.println("\nTEAM " + (j+1) + ": ");
				System.out.println("Item at Position " + position + " is " + lists.get(j).get(position-1));
				
			}
			retrieve2 = System.nanoTime();
			//calculate and output time it took to retrieve
			arrayretrieve = (int) (retrieve2 - retrieve1);
			System.out.println("Time to retrieve element is: " + (retrieve2 - retrieve1));
			
			//add new element to each team
			String newelement = "dandelion";
			insert1 = System.nanoTime();

			for(int k = 0; k < teams; k++){
				lists.get(k).add(position-1, newelement);
			}
			
			insert2 = System.nanoTime();
			//calculate and output time it took to insert new element
			System.out.println("\nNew Item: " + newelement + " has been added to all times at position " + position);
			
			//output each teams list to show new element at given position
			for (int t = 0; t < teams; t++){
				System.out.println("\n TEAM " + (t+1) + ": ");
				for (int i = 0; i < teamList.size(); i++){
					System.out.print("[" + (i+1) + ". " + lists.get(t).get(i) + "]");
				}
			}
			
			//calculate and output time it took to insert new element
			arrayinsert = (int) (insert2 - insert1);
			System.out.println("\nTime to insert new element is: " + (insert2 - insert1));
		
			//retrieve random item
			random1 = System.nanoTime();
			//produce a random number between 1 and 100
			Random r = new Random();
			int result = r.nextInt(100-1) + 1;
			System.out.println("\nRandom number chosen between 1 and 100 : " + result);
			//get item at position at random number
			for(int j = 0; j < teams; j++){
				System.out.println("\nTEAM " + (j+1) + ": ");
				System.out.println("Item at Position " + result + " is " + lists.get(j).get(result-1));
				
			}

			random2 = System.nanoTime();
			//caclulate and output time it took to retrieve item at random number
			arrayrandom = (int) (random2 - random1);
			System.out.println("\nTime to retrieve random element is: " + (random2 - random1));
			break;
		}//end of case 1
		//case2: user chose linkedlist
		case 2:{
			
			//load array for each team
			while (teamBool){
				System.out.println("\nHow many teams would you like to form?");
				String inputGet = reader.next();
				//test for valid input
				try{
					teams = Integer.valueOf(inputGet);
					teamBool = false;
				} catch(NumberFormatException exception){
					teamBool = true;
				} 
			}
			load1 = System.nanoTime();
			for (int t = 0; t < teams; t++){
				//shuffle list and distribute to each team
				Collections.shuffle(lteamList);
				llists.add(new ArrayList<String>(lteamList));
				System.out.println("\n TEAM " + (t+1) + ": ");
				for (int i = 0; i < lteamList.size(); i++){
					System.out.print("[" + (i+1) + ". " + lteamList.get(i) + "]");
				}
			}
			load2 = System.nanoTime();
			//calculate and output time it took to load list to each time
			linkedload = (int) (load2 - load1);
			System.out.println("\nTime to load ArrayList is: " + (load2 - load1));
			
			//get position for retrieving and inserting elements
			
			while(posBool){
				System.out.println("\nWhat position would you like to use for retreiving and inserting?");
				String inputget2 = reader.next();
				//test for valid input
				try{
					position = Integer.valueOf(inputget2);
					posBool = false;
					
				}
				catch(NumberFormatException exception){
					posBool = true;
				}
			}
			//retrieve item at user chosen position
			retrieve1 = System.nanoTime();
			for(int j = 0; j < teams; j++){
				System.out.println("\nTEAM " + (j+1) + ": ");
				System.out.println("Item at Position " + position + " is " + llists.get(j).get(position-1));
				
			}
			retrieve2 = System.nanoTime();
			
			//calculate and output total time it took to retrieve item at chosen index
			linkedretrieve = (int) (retrieve2 - retrieve1);
			System.out.println("Time to retrieve element is: " + (retrieve2 - retrieve1));
			
			//add new element to each team
			String newelement = "dandelion";
			insert1 = System.nanoTime();

			for(int k = 0; k < teams; k++){
				llists.get(k).add(position-1, newelement);
			}
			
			insert2 = System.nanoTime();
			System.out.println("\nNew Item: " + newelement + " has been added to all times at position " + position);
			//output list for each team to show new item added
			for (int t = 0; t < teams; t++){
				System.out.println("\n TEAM " + (t+1) + ": ");
				for (int i = 0; i < lteamList.size(); i++){
					System.out.print("[" + (i+1) + ". " + llists.get(t).get(i) + "]");
				}
			}
			linkedinsert = (int) (insert2 - insert1);
			//calculate and output total time it takes to insert element at chosen index
			System.out.println("\nTime to insert new element is: " + (insert2 - insert1));
			
			
			
			//retrieve random item
			random1 = System.nanoTime();
			Random r = new Random();
			//get a random number between 1 and 100
			int result = r.nextInt(100-1) + 1;
			System.out.println("\nRandom number chosen between 1 and 100 : " + result);
			//retrrieve item at random index
			for(int j = 0; j < teams; j++){
				System.out.println("\nTEAM " + (j+1) + ": ");
				System.out.println("Item at Position " + result + " is " + llists.get(j).get(result-1));
				
			}

			random2 = System.nanoTime();
			//calculate and output total time it took to retrieve item at random index
			linkedrandom = (int) (random2 - random1);
			System.out.println("\nTime to retrieve random element is: " + (random2 - random1));
			break;
		}//end of case2

		
		}//end of switch case
		
		//output time results for array/linkedlist depending on user's choice
		if(listChoice == 1){
			System.out.println("Scavenger Hunt was done using ArrayLists");
			System.out.println("Load: " + arrayload);
			System.out.println("Retrieve: " + arrayretrieve);
			System.out.println("Insert: " + arrayinsert);
			System.out.println("Random: " + arrayrandom);
		}
		else if(listChoice == 2){
			System.out.println("Scavenger Hunt was done using LinkedList");
			System.out.println("Load: " + linkedload);
			System.out.println("Retrieve: " + linkedretrieve);
			System.out.println("Insert: " + linkedinsert);
			System.out.println("Random: " + linkedrandom);
		}
		
		
		
		}//end of main

}

//test results using 3 groups and index 3
//Scavenger Hunt was done using ArrayLists
//Load: 9,818,000
//Retrieve: 331,000
//Insert: 33,000
//Random: 341,000
//
//Scavenger Hunt was done using LinkedList
//Load: 10,672,000
//Retrieve: 421,000
//Insert: 53,000
//Random: 272,000


//Analysis:
//I recommend ArrayLists because for using an index, 
//it is quicker to retrieve and insert because it can directly access the element. 
//LinkedLists, on the other hand, must cycle through the list before finding the element.