package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {
	public String name;
	protected List<String> notebook;
	protected List<Card> playerCards;
	public Pawn character;
	public List<String>accusationWords;
	
	public Player(String name){
		notebook=new ArrayList<String>();
		playerCards = new ArrayList<Card>();
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public Pawn getCharacter() {
		return character;
	}
	
	
	public List<Card> getPlayerCards() {
		return playerCards;
	}
	
	public boolean contains(Card card) {
		boolean contains = false;
		for (int i=0; i< playerCards.size();i+=1) {
			if (playerCards.get(i).equals(card))
				contains = true;
		}
		return contains;
	}
	
	

    public void raiseAccusation(Game game, Board board){
    	accusationWords = new ArrayList<String>();
    	for(int t=0;t<game.charPawn.size();t++){  
	           System.out.println((t+1)+") "+game.charPawn.get(t).getName());  
	       } 
	//	while(true){
		       System.out.println("who do you accuse could be the killer?" );
 	              Scanner in=new Scanner(System.in); 
	                     int person=in.nextInt();
	            //        if(person>=1 && person<=game.charPawn.size()){
	             //         break;
		         //     }
	//	}
	    System.out.println("with what weapon?");
	    for(int t=0;t<game.weaponPawn.size();t++){  
             System.out.println((t+1)+") "+game.weaponPawn.get(t).getName());  
                                                  } 
//	     while(true){
	            Scanner sc=new Scanner(System.in); 
	            int weapon=sc.nextInt();
	     //       if(weapon>=1 && weapon<=game.weaponPawn.size()){
	     //                  break;
	     //             }
	  //   }
	             accusationWords.add(game.charPawn.get(person).getName());
	             accusationWords.add(game.weaponPawn.get(weapon).getName());
	             accusationWords.add(board.findRoomName(this));
    	notebook.add("I formulated the accusation that"+person+" made the murder in the"+character.getPosition()+" with the"+weapon);
    	System.out.print("Are you sure? If the accusation is wrong, you will be delete forever \n 1) yes \n 2) no");
    	Scanner ce=new Scanner(System.in);
    	int choice=ce.nextInt();
    	if(choice==1){
    		if(game.mystery.get(0).getName().equals(accusationWords.get(0)) && game.mystery.get(1).getName().equals(accusationWords.get(0)) && game.mystery.get(2).getName().equals(accusationWords.get(1))){
    			System.out.println("Congratulations! You have won the game!");
    		}
    			else{
    				game.users.remove(this);
    				
    			}
    		if(choice==2){
    			
    		}
    	}
    }

    
 
	public void movement(){
		int pos=character.getPosition();
		Random rand = new Random();
		int dice1 = rand.nextInt(6)+1;
		int dice2 = rand.nextInt(6)+1;
		int diceroll=dice1+dice2;
		int resp1;
		System.out.println("you have rolled a " + diceroll );
				
		while(true) {
			if (pos==20 || pos==50 || pos==70 || pos==90) {
				System.out.println("Would you like to, \n 1) move left \n 2) move right \n 3) stay \n 4)shortcut");
				Scanner in=new Scanner(System.in);
				resp1=in.nextInt();
			}
			else {
				System.out.println("Would you like to, \n 1) move left \n 2) move right \n 3) stay");
				Scanner in=new Scanner(System.in);
				resp1=in.nextInt();
			}
			
			
			if(resp1==3) {
				break;
			}
			else if(resp1==1){
				while(true) {
					System.out.println("How many steps do you want to go?");
					Scanner resp2=new Scanner(System.in);
					int amount=resp2.nextInt();
					if (amount<=diceroll) {
						character.setPosition(pos-amount % 100);
						break;
					}
				}
				break;
			}
			else if(resp1==2){
				while(true) {
					System.out.println("How many steps do you want to go?");
					Scanner resp2=new Scanner(System.in);
					int amount=resp2.nextInt();
					if (amount<=diceroll) {
						character.setPosition(pos+amount % 100);
						break;
					}
				}
				break;
			}
			else if(resp1==4){
				while(true) {
					if 		(pos==20)	character.setPosition(70);
					else if (pos==50)	character.setPosition(90);
					else if (pos==70)	character.setPosition(20);
					else if (pos==90)	character.setPosition(50);
					break;
					}
				}
				break;
			}
		}
			
		public void choice(Game game,Board board) {
			while(true) {
				int resp;
				int pos=character.getPosition();
				System.out.println("Would you like to, \n 1) make acusation \n 2) make hypothesis \n 3) do nothing");
				Scanner in=new Scanner(System.in);
				resp=in.nextInt();
				
				if (resp==1) {
				raiseAccusation(game, board);
				}
				else if (resp==2) {
					if (pos==10 || pos==20 ||pos==30 ||pos==40 ||pos==50 ||pos==60 ||pos==70 ||pos==80 ||pos==90) {
						//Put hypothis method here
						hepo.makeHypothesis(this, game, board);
						break;
					} else {
						System.out.println("You are not in a room");
					}
				}
				else if (resp==3) {
					break;
				}
			}
		}
		
		
		
		
		
}
		
		
		
		
		