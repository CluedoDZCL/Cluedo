package ie.ucd.cluedo;

import java.util.Scanner;

public class Hypothesis {
	int y=0;
	int z=0;
	int t=0;
	public Hypothesis(Player X){
		for(int t=0;t<Game.charPawn.size();t++){  
	           System.out.println((t+1)+") "+Game.charPawn.get(t).getName());  
	       } 
		System.out.println("who do you suspect could be the killer?" );
    	Scanner in=new Scanner(System.in); 
   	    int person=in.nextInt();
   	    System.out.println("with what weapon?");
   	 for(int t=0;t<Game.weaponPawn.size();t++){  
         System.out.println((t+1)+") "+Game.weaponPawn.get(t).getName());  
     } 
   	    Scanner sc=new Scanner(System.in); 
	    int weapon=sc.nextInt();
    	
	    X.notebook.add("I formulated the hypothesis that"+Game.charPawn.get(person).getName()+" made the murder in the"+X.character.getPosition()+" with the"+Game.weaponPawn.get(weapon).getName());
    	
    	//find out the related cards//
    	int c=Game.getCard(person);
    	int y=Game.getCard(Game.charCards.get(c));//who possess the card
    	if(y>0){
    		Game.users.get(y).notebook.add(X+"formulated the hypothesis that"+person+"  made the murder in the "+X.character.getPosition()+" with the"+weapon);
    		Game.users.get(y).notebook.add("I refuted the hypothesis showing card"+Game.charCards.get(c));
        	X.notebook.add(Game.users.get(y)+"refuted the hypothesis showing the card"+Game.charCards.get(c));
        	for(int j=0;j<Game.users.size();j++){
        		if(!Game.users.get(j).getName().equals(X) && !Game.users.get(j).getName().equals(Game.users.get(y).getClass())){
        			Game.users.get(j).notebook.add(X+"made the hypothesis that"+person+"made the murder in the "+X.character.getPosition()+" with the"+weapon);
        			Game.users.get(j).notebook.add(Game.users.get(y)+"refuted the hypothesis showing a card");
        		}
        	}
    	}
		int w=Game.getCard(weapon);
		int z=Game.getCard(Game.weaponCards.get(w));
		if(z>0){
			Game.users.get(z).notebook.add(X+"formulated the hypothesis that"+person+"  made the murder in the "+X.character.getPosition()+" with the"+weapon);
    		Game.users.get(z).notebook.add("I refuted the hypothesis showing card"+Game.charCards.get(w));
        	X.notebook.add(Game.users.get(y)+"refuted the hypothesis showing the card"+Game.charCards.get(w));
        	for(int j=0;j<Game.users.size();j++){
        		if(!Game.users.get(j).getName().equals(X) && !Game.users.get(j).getName().equals(Game.users.get(z).getName())){
        			Game.users.get(j).notebook.add(X+"made the hypothesis that"+person+"made the murder in the "+X.character.getPosition()+" with the"+weapon);
        			Game.users.get(j).notebook.add(Game.users.get(z)+"refuted the hypothesis showing a card");
			
		}
		
        	}
	}}
	
	public void moveChar(CharPawn character, int newPosition) {
		character.position=newPosition;
	}
	
	public void moveWeapon(WeaponPawn weapon, int newPosition) {
		weapon.position=newPosition;
	}
}


