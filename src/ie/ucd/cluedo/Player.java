package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	protected List<String> Notebook;
	protected List<Card> playerCards;
	
	public Player(){
		playerCards = new ArrayList<Card>();		
	}
	
	public List<Card> getPlayerCards() {
		return playerCards;
	}
	
    public void raiseHypothesis(CharPawn A, CharPawn E, WeaponPawn B, Card D){
    	System.out.println("I formulated the hypothesis that"+E+" made the murder in the"+A.getPosition()+" with the"+B.getName());
    	 }
    public void raiseAccusation(CharPawn A, CharPawn E, WeaponPawn B, Card D){
    	System.out.println("I formulated the accusation that"+E+" made the murder in the"+A.getPosition()+" with the"+B.getName());
    }
    public void defenceHypothesis(CharPawn C, CharPawn A, CharPawn E, WeaponPawn B, Card D,String name){
    	System.out.println(A+"formulated the hypothesis that"+E+"  made the murder in the "+A.getPosition()+" with the"+B.getName());
    	System.out.println("I refuted the hypothesis showing card"+D);//need to be modified!
    }
    public void rejectHypothesis(CharPawn A, CharPawn C, CharPawn E, WeaponPawn B, Card D){
    	System.out.println(C+"refuted the hypothesis showing the card"+D);
    }
    public void everHypothesis(CharPawn A, CharPawn C, CharPawn E, WeaponPawn B){
    	System.out.println(A+"made the hypothesis that"+E+"made the murder in the "+A.getPosition()+" with the"+B.getName());
    	System.out.println(C+"refuted the hypothesis showing a card");
    }
    protected void initializeNotebook(){
    	Notebook.add("scarlett");
    	Notebook.add("plum");
    	Notebook.add("peacock");
    	Notebook.add("green");
    	Notebook.add("mustard");
    	Notebook.add("white");
    	
    	Notebook.add("kitchen");
    	Notebook.add("ballroom");
    	Notebook.add("conservatory");
    	Notebook.add("dining");
    	Notebook.add("lounge");
    	Notebook.add("hall");
    	Notebook.add("study");
    	Notebook.add("billiard");
    	Notebook.add("library");
    	
    	Notebook.add("candlestick");
    	Notebook.add("knife");
    	Notebook.add("pipe");
    	Notebook.add("revolver");
    	Notebook.add("rope");
    	Notebook.add("poison");
    }
    protected void delEleNotebook(){
    	System.out.println("Please print the item you want to add in the Notebook");
    	Scanner in=new Scanner(System.in);
    	String name=in.nextLine();
    	Notebook.remove(name);
    	
    }
    protected void addEleNotebook(){
    	System.out.println("Please print the item you want to add in the Notebook");
    	Scanner in=new Scanner(System.in);
    	String name=in.nextLine();
    	Notebook.add(name);
     }
    
    
}
