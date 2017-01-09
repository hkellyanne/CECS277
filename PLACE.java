/*
 * 1) Kelly Hall
 * 2) November 30, 2016
 * 3) input a number of animal contestents and have them race 100 paces.
 * 4) Input: number of contestents
 * 5) Output: Animals, their pace, laps, and place.
 */
import java.util.ArrayList;
	//create arraylist, add animals into it to indicate their place in the race
	class PLACE{
		ArrayList<Animal> myArray = new ArrayList<Animal>();
		public void setArray(ArrayList<Animal> mysecondArray){
			 this.myArray = mysecondArray;
		}
		public ArrayList<Animal> getArray(){
			return myArray;
		}
		
		
	}