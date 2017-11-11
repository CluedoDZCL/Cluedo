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
    	
    	//find out the related cards//
    	
    	//find out who possess the cards//
    	if(true){
    		Y.notebook.add(X+"formulated the hypothesis that"+person+"  made the murder in the "+X.character.getPosition()+" with the"+weapon);
        	Y.notebook.add("I refuted the hypothesis showing card"+C);
        	X.notebook.add(Y+"refuted the hypothesis showing the card"+C);
        	for(int j=0;j<Game.users.size();j++){
        		if(!Game.users.get(j).getName().equals(X) && !Game.users.get(j).getName().equals(Y)){
        			Game.users.get(j).notebook.add(X+"made the hypothesis that"+person+"made the murder in the "+X.character.getPosition()+" with the"+weapon);
        			Game.users.get(j).notebook.add(Y+"refuted the hypothesis showing a card");
        		}
        		
        	}
    	}
		
	}

}
