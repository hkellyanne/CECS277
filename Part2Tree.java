/*
 * 1) Kelly Hall
 * 2) November 15, 2016
 * 3) Store words of Alice in Wonderland in a Treeset and calculate the time it takes
 * 4) Input: none
 * 5) Output: Total time it takes to store Alice in Wonderland in a Treeset
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;


public class Part2Tree {
	public static void main(String args[]){
		Scanner in = null;
		//create treeset
		TreeSet<String> myTreeSet = new TreeSet();
		//initialize file
		File file = new File("AliceinWonderland.txt");

		try{
		in = new Scanner(file);
		
		//calculate run time
		final long startTime = System.currentTimeMillis();
		while(in.hasNext()){
			//store file into treeset
			myTreeSet.add(in.next());

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
