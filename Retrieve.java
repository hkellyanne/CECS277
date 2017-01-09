/*
 * 1) Kelly Hall
 * 2) September 26, 2016
 * 3) Create a text file memo and display it
 * 4) Input: memo
 * 5) Output: memo name, memo content, date memo was created. 
 */

package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Retrieve {

	public static void main(String[] args) throws FileNotFoundException{
		String userinput = "y";
		boolean check = false;
		
while(!check){
		
		JFileChooser chooser = new JFileChooser();
		int selection = chooser.showOpenDialog(null);
		//open file chooser
		if (selection == JFileChooser.APPROVE_OPTION)
		{
			Scanner in;
			Scanner console = new Scanner(System.in);
			try{
				File selectedFile = chooser.getSelectedFile();
				in = new Scanner(selectedFile);
				while(userinput.toLowerCase().equals("y")){
					if(!in.hasNextLine()){//check if end of file
						System.out.println("end of file");
						System.exit(0);						
					} 
					else {//print 3 lines
						for(int i = 0; i < 3; i++){
							System.out.println(in.nextLine());
	
						}//end of for	
					//prompt user to keep reading memo.txt
					System.out.println("Do you want to read the next Memo? (Y/N)");
					userinput = console.nextLine();	
					}
					//end loop if user enters "n"
					if (userinput.equals("n")){
						check = true;

					}
					


				}//end of while
				in.close();				
			}//end of try
		
			
			catch(FileNotFoundException exception){
				//re-loop if file is not found
				System.out.println("File not found: " + chooser.getSelectedFile().getName());
				check = false;
				
			}//end of catch
		}
		else if (selection == JFileChooser.CANCEL_OPTION ){
			check = true;
		}
		}// end of if

	}//end of main

}//end of retrieve
