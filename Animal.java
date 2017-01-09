/*
 * 1) Kelly Hall
 * 2) November 30, 2016
 * 3) input a number of animal contestents and have them race 100 paces.
 * 4) Input: number of contestents
 * 5) Output: Animals, their pace, laps, and place.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Animal extends Thread{
	//initialize variables
	int DELAY;
	int SPEED;
	int PACE;
	int LAP;
	
	//initialize object of PLACE
	PLACE place;
	
	//initialize lock
	private Lock placeLock;
	
	//initialize scanner
	Scanner inAni = null;
	Scanner inName = null;
	
	//initialize Files
	File animal = new File("animals.txt");
	File name = new File("names.txt");
	
	//initialize arraylists
	ArrayList<String> animals = new ArrayList<String>();
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Animal> mysecondArray = new ArrayList<Animal>();


	//constructor
	Animal(PLACE place){
		this.place = place;
		
		//create lock
		placeLock = new ReentrantLock();
		
		//initialize random num
		Random r = new Random();
		
		//set a random DELAY and SPEED(between 0 and 20) for each animal participating
		DELAY = 1000 + 10 * r.nextInt(20);
		SPEED = r.nextInt(15);
		//SPEED cannot = 0
		if (SPEED == 0){
			SPEED += 1;
		}
		//try to read files
		try{
			inAni = new Scanner(animal);
			inName = new Scanner(name);
			
			//if file exists, store in an array
			while(inAni.hasNext()){
				animals.add(inAni.next());
			}
			while(inName.hasNext()){
				names.add(inName.next());
			}
		}//end of try


		//if file is not found
		catch(FileNotFoundException exception){
			System.out.println("File not found");
		}
		//close files
		finally{
			inAni.close();
			inName.close();

		}
		
		//randomly connect a name and an animal together 
		int n = r.nextInt(names.size() - 1);
		int a = r.nextInt(animals.size() - 1);
		setName(names.get(n) + " the " + animals.get(a));
		
		//initialize number of laps
		LAP = 0;

	}


	@Override
	public void run(){

		//while race is going on, output each animals paces and laps
		//each lap is 100 paces
		while (PACE < 30){
			System.out.println(getName() + ": " + PACE);

			try {
				sleep(DELAY);
				PACE += SPEED;
				
				if (PACE >= 30){
					LAP+=1;
					PACE -=30;
					
					//3 laps indicate finishline
					if (LAP == 3){
						mysecondArray = place.getArray();
						mysecondArray.add(this);
						place.setArray(mysecondArray);
						System.out.println(getName() + " is finished at place " + mysecondArray.size());
						break;
					}

					System.out.println(getName() + ": Lap " + LAP);

				}		
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}//end of while
	}//end of run
}//end of inner class