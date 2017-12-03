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
	public Player(String name){
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
	
	
    public void raiseAccusation(Player X){
    	System.out.println("who do you believe would be the killer?" );
    	Scanner in=new Scanner(System.in); 
   	    String person=in.next();
   	    System.out.println("with what weapon?");
   	    Scanner sc=new Scanner(System.in); 
	    String weapon=sc.next();
    	X.notebook.add("I formulated the accusation that"+person+" made the murder in the"+X.character.getPosition()+" with the"+weapon);
    }
    protected void initializeNotebook(){
    	notebook.add("Game start");
     }
	
	public void movement(){
		int pos=character.getPosition();
		Random rand = new Random();
		int dice1 = rand.nextInt(6)+1;
		int dice2 = rand.nextInt(6)+1;
		int diceroll=dice1+dice2;
		int resp;
		System.out.println("you have rolled a " + diceroll );
				
		while(true) {
			System.out.println("Would you like to, \n 1) move left \n 2) move right \n 3) stay?");
			Scanner in=new Scanner(System.in);
			int resp1=in.nextInt();
		
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
		}
			
		
}
    
    
}
