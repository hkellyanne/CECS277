	/*
	 * 1) Kelly Hall
	 * 2) November 6, 2016
	 * 3) Modify FileIO project to read and write an object
	 * 4) Input: memo
	 * 5) Output: memo name, memo content, date memo was created. 
	 */


	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;

import javax.swing.JFileChooser;
public class Memo implements Serializable{
	String memowritten;
	String memotitle;
	Date dateCreated;
	
	public void setMemo(String memo){
		this.memowritten = memo;
		
	}
	public String getMemo(){
		return memowritten;
	}
	
	public void setMemoTitle(String memotitle){
		this.memotitle = memotitle;
		
	}
	public String getMemoTitle(){
		return memotitle;
	}
	public void setDate(Date dateCreated){
		this.dateCreated = new Date();
		
	}
	public Date getDate(){
		return dateCreated;
	}
	
	public String toString(){
		return "DateCreated: " + dateCreated + "\nMemo title: " + memotitle + "\nMemo: " + memowritten;
	}
	

		public static void main(String[] args) {
			//initialize variables
			String userinput = "y";
			boolean check = false;
			FileInputStream fis;
			ObjectInputStream ois;
			int counter = 0;
			
	while(!check){
			//pop up file chooser
			JFileChooser chooser = new JFileChooser();
			int selection = chooser.showOpenDialog(null);
			//open file chooser
			if (selection == JFileChooser.APPROVE_OPTION)
			{								
				try{
					Scanner console = new Scanner(System.in);
					
					 //reading in
					 File selectedFile = chooser.getSelectedFile();
					 fis = new FileInputStream(selectedFile.getName());
					 ois = new ObjectInputStream(fis);
					 //read objects in arraylist
					 ArrayList<Memo> memoArray = (ArrayList<Memo>) ois.readObject();
					 ois.close();
					 
					 //if there is nothing in the array, end of file is reached
					 if(memoArray == null){
						 System.out.println("end of file");
					 }

					 //check user input
					 while(userinput.toLowerCase().equals("y")){
						 //if you have reached end of array
						 if (counter == memoArray.size()) break;
						 //get memo at index, and then increase counter to receive next index
						 System.out.println(memoArray.get(counter));
						 counter+=2;
						//prompt user to keep reading memo.txt
						 
						System.out.println("Do you want to read the next Memo? (Y/N)");
						userinput = console.nextLine();	
						
						
						//end loop if user enters "n"
						if (userinput.equals("n")){
							check = true;

						}

					 }//end of while

					 }//end of try
					//exceptions
						catch(FileNotFoundException e){
							System.out.println("File not found: " + chooser.getSelectedFile().getName());
							check = false;
							e.printStackTrace();
						} catch(IOException e){
							e.printStackTrace();
						} catch(ClassNotFoundException e){
							e.printStackTrace();
						}
				//finally, end of program is reached
				finally{
					System.out.println("End");
					}
			}//end of if
			else if (selection == JFileChooser.CANCEL_OPTION ){
				check = true;
			}
		
				}//end of while
			
		}

		}//end of main




