/*
 * 1) Kelly Hall
 * 2) September 26, 2016
 * 3) Create a text file memo and display it
 * 4) Input: memo
 * 5) Output: memo name, memo content, date memo was created. 
 */

package FileIO;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Store {
	public static void main(String[] args) {
	PrintWriter open = null;	
		
	Date dateCreated = new Date();
	
	//try to write to memo.txt file
	try{
		open = new PrintWriter("memo.txt");
	} 
	catch (FileNotFoundException exception)//if memo does not exist, catch
	{
	    System.out.println("File not Found");
	}
    Scanner console = new Scanner(System.in);
    
    //enter memo topic
	String userinput = null;
	System.out.println("memo topic(enter -1 to end):\n");
	userinput = console.nextLine();
	
	while (!userinput.equals("-1")){
		open.println(dateCreated);
		open.println(userinput);
		
		//enter memo text
		System.out.println("memo text:\n");
		userinput = console.nextLine();
		open.println(userinput);
		
		//enter memo topic
		System.out.println("memo topic(enter -1 to end):\n");
		userinput = console.nextLine();
		
	}// end of while
	//close file
    open.close();
	

}// end of main
}//end of store

