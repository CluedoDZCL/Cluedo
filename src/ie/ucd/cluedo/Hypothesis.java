package ie.ucd.cluedo;

import java.util.List;
import java.util.Scanner;

public class Hypothesis {
    protected List<String> keyword; // the list of the room name, weapon name, and person name
	public Hypothesis(Player X){
		for(int t=0;t<Game.charPawn.size();t++){  
	           System.out.println((t+1)+") "+Game.charPawn.get(t).getName());  
	       } 
	//	while(true){
		       System.out.println("who do you suspect could be the killer?" );
    	              Scanner in=new Scanner(System.in); 
   	                     int person=in.nextInt();
   	            //        if(person>=1 && person<=Game.charPawn.size()){
   	             //         break;
		         //     }
	//	}
   	    System.out.println("with what weapon?");
   	    for(int t=0;t<Game.weaponPawn.size();t++){  
                System.out.println((t+1)+") "+Game.weaponPawn.get(t).getName());  
                                                     } 
   //	     while(true){
   	            Scanner sc=new Scanner(System.in); 
   	            int weapon=sc.nextInt();
   	     //       if(weapon>=1 && weapon<=Game.weaponPawn.size()){
	     //                  break;
   	     //             }
   	  //   }
   	          
   	     keyword.add(Game.charPawn.get(person).getName());
   	     keyword.add(Game.weaponPawn.get(weapon).getName());
	    X.notebook.add("I formulated the hypothesis that"+Game.charPawn.get(person).getName()+" made the murder in the"+X.character.getPosition()+" with the"+Game.weaponPawn.get(weapon).getName());
    	
    	//find out the related cards//
	    for(int t=0;t<3;t++){
    	int cardIndex=Game.findCard(keyword.get(t));
    	int holderIndex=Game.getCard(Game.charCards.get(cardIndex));//who possess the card
    	if(holderIndex>0){
    		Game.users.get(holderIndex).notebook.add(X+"formulated the hypothesis that"+Game.charPawn.get(person).getName()+"  made the murder in the "+X.character.getPosition()+" with the"+Game.weaponPawn.get(weapon).getName());
    		Game.users.get(holderIndex).notebook.add("I refuted the hypothesis showing card"+keyword.get(t));
        	X.notebook.add(Game.users.get(holderIndex)+"refuted the hypothesis showing the card"+keyword.get(t));
        	for(int j=0;j<Game.users.size();j++){
        		if(!Game.users.get(j).getName().equals(X) && !Game.users.get(j).getName().equals(Game.users.get(holderIndex).getClass())){
        			Game.users.get(j).notebook.add(X+"made the hypothesis that"+person+"made the murder in the "+X.character.getPosition()+" with the"+weapon);
        			Game.users.get(j).notebook.add(Game.users.get(holderIndex)+"refuted the hypothesis showing a card");
        		}
        	}
    	}}
		
	}
	
	public void moveChar(CharPawn character, int newPosition) {
		character.position=newPosition;
	}
	
	public void moveWeapon(WeaponPawn weapon, int newPosition) {
		weapon.position=newPosition;
	}
}


