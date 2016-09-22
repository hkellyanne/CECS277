/*
 * Kelly Hall
 * August 24, 2016
 * This program is a 2 Player game of War
 * input: prompts user to play war
 * output: cards played, score and which player wins
 */

package war_game;
import java.util.*;
import java.util.Scanner;

//create deck of cards
public class war{
	
	public static void main(String[] args){
		int valuep = 0;
		int valuec = 0;
		int warvaluep = 0;
		int warvaluec = 0;

	ArrayList<String> rank = new ArrayList<String>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"));
	ArrayList<String> suit = new ArrayList<String>(Arrays.asList("hearts", "diamonds", "Spades", "clubs"));
	ArrayList<Integer> values = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));
	ArrayList<String> deck = new ArrayList<String>();
	ArrayList<Integer> valuedeck = new ArrayList<Integer>();
	
	//concoct suit and value arraylists
	for (int i=0; i < rank.size(); i++){
		for(int j=0; j < suit.size(); j++){
		deck.add(rank.get(i) + " of " + suit.get(j));
		valuedeck.add(values.get(i));
		}
	}

	
//	for (int k=0; k < deck.size(); k++){ // check if array contains all cards
//	System.out.println(deck.get(k));
//	}
//	for (int l=0; l < valuedeck.size(); l++){ // check if array contains all values
//	System.out.println(valuedeck.get(l));
//	}
//	for (int m=0; m < finaldeck.size(); m++){ // check if array contains all values
//	System.out.println(finaldeck.get(m));
//	}
// //double check if deck contains all values
//	System.out.println(deck.size());
//	System.out.println(finaldeck.size());

	Scanner console = new Scanner(System.in);
	//prompt user to play war
	System.out.println("Menu \n 1) Play War \n 2) exit \n");
	int input1 = console.nextInt();
	 
		if (input1 == 1){
			Collections.shuffle(deck); //shuffle and deal cards evenly
		
			ArrayList<String> player = new ArrayList<String>();
			ArrayList<String> computer = new ArrayList<String>();
			
			for (int i = 0; i < 26; i++){
				player.add(deck.get(i));
			}
			for (int j = 26; j < 52; j++){
				computer.add(deck.get(j));
			}
		
//			//check if cards were dealed properly			
//			for (int k = 0; k < player.size(); k++){
//				System.out.println(player.get(k));
//			}
//			System.out.println("\n\n\n\n\n\n\n");
//			
//			for (int l = 0; l < computer.size(); l++){
//				System.out.println(computer.get(l));
//			}

		
			System.out.println("Shuffling....");
			while(!computer.isEmpty() && !player.isEmpty()){ //loop game as long as user inputs "1" and neither arrays are empty
					System.out.println("Player Score:" + player.size() + "    " + player.get(0) + "\n                   "  + 
					computer.get(0) + "    Computer Score:" + computer.size());
					valuec = getValue(computer.get(0));
					valuep = getValue(player.get(0));
					
					//if computer card has a higher value than player card
					if (valuec > valuep){
						addToDeck(computer,player,0);
					}
					//if player card has a higher value than computer card
					else if(valuec < valuep){
						addToDeck(player,computer,0);
					}
					
					//if player and computer cards have equal values then WAR
					else if(valuec == valuep){
						//end game if there are too few cards for a full WAR
						if (player.size() < 5 || computer.size() < 5){

							int finalcardc = computer.size() - 1;
							int finalcardp = player.size() - 1;
							computer.set(0, computer.get(finalcardc));
							player.set(0, player.get(finalcardp));
							System.out.println("FINAL WAR");
							System.out.println("Player final card:" + "    " + player.get(0) + "\n"  + 
									  "Computer final card:   " + computer.get(0));
							if (valuec > valuep){
								System.out.println("YOU LOSE");
								System.out.println("final Score\nComputer: 52" + "\nPlayer: 0");
							}
							else {
								System.out.println("YOU WIN");
								System.out.println("final Score\nComputer:0" + "\nPlayer:52");
							}
							System.exit(0);
						}
						warvaluec = getValue(computer.get(4));
						warvaluec = getValue(player.get(4));
						//deal out 3 face down cards
						System.out.println("WAR\n");
						System.out.println("Player:" +  "       xx " +  
											"\n              xx        :Computer");
						System.out.println("Player:" +  "       xx " +  
											"\n              xx        :Computer");
						System.out.println("Player:" +  "       xx " +  
											"\n              xx        :Computer");
						// determining who wins in WAR
						System.out.println("Player Score:" + player.size() + "    " + player.get(4) + "\n                  "  + 
								computer.get(4) + "    Computer Score:" + computer.size());
						//winner gets a total of 5 cards
						if (warvaluec > warvaluep){
							for (int c=0; c<5; c++){
								addToDeck(computer, player, c);
							}

						}
						else if(warvaluec < warvaluep){
							for (int a=0; a<5; a++){
								addToDeck(player,computer,a);
							}

						}
						//if war happens again
						else if (warvaluec == warvaluep){
							System.out.println("TIE. playing next card..");
							warvaluec = getValue(computer.get(5));
							warvaluep = getValue(player.get(5));
							System.out.println("Player Score:" + player.size() + "    " + player.get(5) + "\n                  "  + 
									computer.get(5) + "    Computer Score:" + computer.size());
							//if computer card has a higher value than player card
							if (warvaluec > warvaluep){
								addToDeck(computer,player,5);
								for (int c = 0; c < 4; c++){
                                    addToDeck(computer, player, c);
                                }
							}
							//if player card has a higher value than computer card
							else if(warvaluec < warvaluep){
								addToDeck(player,computer,5);
								for (int a = 0; a < 4; a++){
                                    addToDeck(player, computer, a);
							}	
						}
					}		
			}
			}
			if (computer.size() == 1){ //when game is played out
				System.out.println("final Score\nComputer:0" + "\nPlayer:52");
					System.out.println("YOU WIN");
			}

				else { //else computer wins
				System.out.println("final Score\nComputer:52" + "\nPlayer:0");
				System.out.println("YOU LOSE");
				}
			}
		
		else{ System.out.println("goodbye!");}
		}	
	//initializing values of cards
	public static int getValue(String card){
        if(card.contains("2")) { return 2; }
        else if(card.contains("3")) { return 3; }
        else if(card.contains("4")) { return 4; }
        else if(card.contains("5")) { return 5; }
        else if(card.contains("6")) { return 6; }
        else if(card.contains("7")) { return 7; }
        else if(card.contains("8")) { return 8; }
        else if(card.contains("9")) { return 9; }
        else if(card.contains("10")) { return 10; }
        else if(card.contains("Jack")) { return 11; }
        else if(card.contains("Queen")) { return 12; }
        else if(card.contains("King")) { return 13; }
        else if(card.contains("Ace")) { return 14; }
        return 0;	
	}
	//adds cards to winners stack
	public static void addToDeck(ArrayList winner, ArrayList loser, int cardnum){
		winner.add(loser.get(cardnum));
		loser.remove(cardnum);
		winner.add(winner.get(cardnum));
		winner.remove(winner.get(cardnum));
		
	}
		
	}
	

	
	

	


	
	
	
	


	
	
	
	
	
	