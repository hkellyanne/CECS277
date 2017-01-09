/*
 * 1) Kelly Hall
 * 2) December 1, 2016
 * 3) find out how many times a pattern occurs in a .txt file
 * 4) Input: N/A
 * 5) Output: the number of times a specific pattern occurs in the text file
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;


public class RegEx {
	
	public static void main (String args[]){
		//initialize count variables
		
		int zzcount = 0;
		int vowel2count = 0;
		int manyvowelcount = 0;
		int xxcount = 0;
		int qcount = 0;
		
		//initialize scanner
		Scanner in = null;
		
		//initialize printwriter
		PrintWriter out = null;
		
		//create an ArrayList
		ArrayList<String> scrabblewords = new ArrayList<String>();

		//declare file
		File scrabble = new File("scrabble.txt");
		
		//try to read files
		try{
		in = new Scanner(scrabble);
		out = new PrintWriter("qout.txt");

		while(in.hasNext()){
			scrabblewords.add(in.nextLine());

			}
		
		//all words with two z's in a row (385 words)
		for (int i = 0; i < scrabblewords.size(); i++){
			String pattern = ".*[z]+[z].*";
			String text = scrabblewords.get(i);
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(text);
			while(m.find()){
				zzcount++;
			}	
		}
		System.out.println("Number of words with two z's in a row: " + zzcount);

		
		
		//all words with two vowels in a row (63864 words)
		for (int i = 0; i < scrabblewords.size(); i++){
			String pattern = ".*[aeiou]+[aeiou].*";
			String text = scrabblewords.get(i);
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(text);
			while(m.find()){
				vowel2count++;
			}	
		}
		System.out.println("Number of words with two vowels in a row: " + vowel2count);

		//all words with more than two vowels (132420 words)
		for (int i = 0; i < scrabblewords.size(); i++){
			String pattern = "(.*[aeiou].*){3,}";
			String text = scrabblewords.get(i);
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(text);
			while(m.find()){
				//System.out.println(text.substring(m.start(), m.end()));
				manyvowelcount++;
			}	
		}
		System.out.println("Number of words with more than two vowels: " + manyvowelcount);
		
		//all words with two x's in them (16 words)
		for (int i = 0; i < scrabblewords.size(); i++){
			String pattern = ".*x.*x.*";
			String text = scrabblewords.get(i);
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(text);
			while(m.find()){
				xxcount++;
			}	
		}
		System.out.println("Number of words with two x's: " + xxcount);

		//all words starting with q not followed by u (25 words) **write these words to a file
		for (int i = 0; i < scrabblewords.size(); i++){
			String pattern = "^[q]+[^u].*";
			String text = scrabblewords.get(i);
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(text);
			while(m.find()){
				out.println(text.substring(m.start(), m.end()));
				qcount++;
			}	
		}
		System.out.println("Number of words starting with q not followed by u: " + qcount);

		}//end of try
		
		//if file is not found
		catch(FileNotFoundException exception){
			System.out.println("File not found");
		}
		//close files
		finally{
			in.close();
			out.close();
		}

		}//end of main

}
