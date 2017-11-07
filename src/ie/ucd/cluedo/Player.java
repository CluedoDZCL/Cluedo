package ie.ucd.cluedo;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	protected List<String> notebook;
	protected List<Card> playerCards;
	public Pawn character;
	public Player(){
		playerCards = new ArrayList<Card>();		
	}
	
	
	public List<Card> getPlayerCards() {
		return playerCards;
	}
	
    public void raiseHypothesis(Player X){
    	System.out.println("who do you suspect could be the killer?" );
    	Scanner in=new Scanner(System.in); 
   	    String person=in.next();
   	    System.out.println("with what weapon?");
   	    Scanner sc=new Scanner(System.in); 
	    String weapon=sc.next();
    	X.notebook.add("I formulated the hypothesis that"+person+" made the murder in the"+X.character.getPosition()+" with the"+weapon);
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
    public void defenceHypothesis(Player X, Player Y, CharPawn A, WeaponPawn B, Card C){
    	Y.notebook.add(X+"formulated the hypothesis that"+A.getName()+"  made the murder in the "+X.character.getPosition()+" with the"+B.getName());
    	Y.notebook.add("I refuted the hypothesis showing card"+C);
    }
    public void rejectHypothesis(Player X, Player Y, Card D){
    	X.notebook.add(Y+"refuted the hypothesis showing the card"+D);
    }
    public void everHypothesis(Player X, Player Y, Player Z, CharPawn A, WeaponPawn B){
    	Z.notebook.add(X+"made the hypothesis that"+A.getName()+"made the murder in the "+X.character.getPosition()+" with the"+B.getName());
    	Z.notebook.add(Y+"refuted the hypothesis showing a card");
    }
    protected void initializeNotebook(){
    	notebook.add("Game start");
     }
    
    
    
}
