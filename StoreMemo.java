	/*
	 * 1) Kelly Hall
	 * 2) October 24, 2016
	 * 3) Modify FileIO project to read and write an object
	 * 4) Input: memo
	 * 5) Output: memo name, memo content, date memo was created. 
	 */



import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class StoreMemo {

		public static void main(String[] args) {
			
		ArrayList<Memo> memoArray = new ArrayList<Memo>();
			

		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		File f = new File("memo.txt");
		Date dateCreated = new Date();
		//create new object of Memo
		Memo memo = new Memo();	
	    Scanner console = new Scanner(System.in);
		
	    
	    //enter memo topic
		String userinput = null;
		System.out.println("memo topic(enter -1 to end):\n");
		userinput = console.nextLine();
		memo.setMemoTitle(userinput);
		
		while (!userinput.equals("-1")){
			memo.setDate(dateCreated);
			
			//enter memo text
			System.out.println("memo text:\n");
			userinput = console.nextLine();
			memo.setMemo(userinput);
			//store memo text
			memoArray.add(memo);
			
			
			memo = new Memo();
			//enter memo topic
			System.out.println("memo topic(enter -1 to end):\n");
			userinput = console.nextLine();
			//store memo topic
			memo.setMemoTitle(userinput);
			
			//add memo into the array
			memoArray.add(memo);

			try{
				//reading out
				 fout = new FileOutputStream(f);
				 oos = new ObjectOutputStream(fout);
				 oos.writeObject(memoArray);
				 oos.close();
			
			

			} catch(FileNotFoundException e){
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			} 
		}// end of while
		//close file
	    //open.close();
		
	}// end of main

}//end of Store Memo
