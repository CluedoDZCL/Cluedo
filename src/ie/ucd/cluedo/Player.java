package ie.ucd.cluedo;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;
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
	
	
	public List<Card> getPlayerCards() {
		return playerCards;
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
    }
