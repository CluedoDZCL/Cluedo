package ie.ucd.cluedo;

import java.util.Scanner;

public class Hypothesis {
	public Hypothesis(Player X){
		System.out.println("who do you suspect could be the killer?" );
    	Scanner in=new Scanner(System.in); 
   	    String person=in.next();
   	    System.out.println("with what weapon?");
   	    Scanner sc=new Scanner(System.in); 
	    String weapon=sc.next();
    	X.notebook.add("I formulated the hypothesis that"+person+" made the murder in the"+X.character.getPosition()+" with the"+weapon);
    	
    	//find out the name related card//
    	for(int i=0;i<9;i++){
    		if(roomCards.get(i).)
    	}
		
	}

}
