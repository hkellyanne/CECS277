/*
 * 1) Kelly Hall
 * 2) November 15, 2016
 * 3) Store words of Alice in Wonderland in a Hashset and calculate the time it takes
 * 4) Input: none
 * 5) Output: Total time it takes to store Alice in Wonderland in a Hashset
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;


public class Part2Hash {
	public static void main(String args[]){
		
		Scanner in = null;
		
		//create hashset
		HashSet<String> myHashSet = new HashSet();
		
		//initialize file
		File file = new File("AliceinWonderland.txt");
		
		//try to read file
		try{
		in = new Scanner(file);
		
		//calculate runtime
		final long startTime = System.currentTimeMillis();
		while(in.hasNext()){
			//store file into hashset
			myHashSet.add(in.next());

		}
		final long endTime = System.currentTimeMillis();
		
		//output total runtime
		System.out.println("Total execution time: " + (endTime - startTime));

		}//end of try
		
		//if file is not found
		catch(FileNotFoundException exception){
			System.out.println("File not found");
		}
		//close file
		finally{
			in.close();
		}
	}

}
