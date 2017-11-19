package ie.ucd.cluedo;

import java.util.List;
import java.util.Scanner;

public class Hypothesis {
    protected List<String> keyword; // the list of the room name, weapon name, and person name
	public Hypothesis(Player X, Game game){
		for(int t=0;t<game.charPawn.size();t++){  
	           System.out.println((t+1)+") "+game.charPawn.get(t).getName());  
	       } 
	//	while(true){
		       System.out.println("who do you suspect could be the killer?" );
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
   	          
   	     keyword.add(game.charPawn.get(person).getName());
   	     keyword.add(game.weaponPawn.get(weapon).getName());
	    X.notebook.add("I formulated the hypothesis that"+game.charPawn.get(person).getName()+" made the murder in the"+X.character.getPosition()+" with the"+game.weaponPawn.get(weapon).getName());
    	
    	//find out the related cards//
	    for(int t=0;t<3;t++){
    	int cardIndex=game.findCard(keyword.get(t));
    	int holderIndex=game.getCard(game.charCards.get(cardIndex));//who possess the card
    	if(holderIndex>0){
    		game.users.get(holderIndex).notebook.add(X+"formulated the hypothesis that"+game.charPawn.get(person).getName()+"  made the murder in the "+X.character.getPosition()+" with the"+game.weaponPawn.get(weapon).getName());
    		game.users.get(holderIndex).notebook.add("I refuted the hypothesis showing card"+keyword.get(t));
        	X.notebook.add(game.users.get(holderIndex)+"refuted the hypothesis showing the card"+keyword.get(t));
        	for(int j=0;j<game.users.size();j++){
        		if(!game.users.get(j).getName().equals(X) && !game.users.get(j).getName().equals(game.users.get(holderIndex).getClass())){
        			game.users.get(j).notebook.add(X+"made the hypothesis that"+person+"made the murder in the "+X.character.getPosition()+" with the"+weapon);
        			game.users.get(j).notebook.add(game.users.get(holderIndex)+"refuted the hypothesis showing a card");
        		}
        	}
    	}}
		
	}
	
	public void movePawn(Pawn pawn, int newPosition) {
		pawn.position=newPosition;
	}
	
	
}


