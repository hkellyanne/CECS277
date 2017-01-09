/*
 * 1) Kelly Hall
 * 2) November 15, 2016
 * 3) Calculate total points of scrabble words that start with q without u following
 * 4) Input: none
 * 5) Output: words that start with q not followed by u with the total scrabble score
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Part1 {
	public static void main (String args[]){
		//initialize scanner
		Scanner inQwords = null;
		Scanner inPoint = null;
		
		//create a map and a set
		Map<String, Integer> map = new HashMap<String, Integer>();
		Set<String> map2 = new TreeSet<String>();
		
		//declare files
		File qwords = new File("Qwords.txt");
		File point = new File("ScrabblePoint.txt");
		
		//try to read files
		try{
		inQwords = new Scanner(qwords);
		inPoint = new Scanner(point);
		
		//if file exists, store in a map
		while(inPoint.hasNext()){
			map.put(inPoint.next(), inPoint.nextInt());	
		}
		
		//calculate point value of each word
		while(inQwords.hasNext()){
			
			String[] Q = inQwords.next().split(" ");
			for(int i = 0; i < Q.length; i++){
				int sum = 0;
				System.out.print(Q[i]);
				for (int j = 0; j < Q[i].length(); j++){
					
					sum += map.get(Character.toString(Q[i].charAt(j)).toUpperCase());
				}
				System.out.println(": " + sum);

			}
		}
		}//end of try
		
		//if file is not found
		catch(FileNotFoundException exception){
			System.out.println("File not found");
		}
		//close files
		finally{
			inQwords.close();
			inPoint.close();
	
		}

		}//end of main

}//end of part1
