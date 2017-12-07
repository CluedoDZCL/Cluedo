package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hypothesis {
    protected List<String> keyword; // the list of the room name, weapon name, and person name
    protected int person;
    protected int weapon;
    
	public Hypothesis(){
		keyword=new ArrayList<String>();
		
	}
	public void makeHypothesis(Player X, Game game, Board board){
		int cardIndex[]=new int[3];
		int x=0;
		for(int t=0;t<game.charPawn.size();t++){  
	           System.out.println((t+1)+") "+game.charPawn.get(t).getName());  
	       } 
		while(true){
		       System.out.println("who do you suspect could be the killer?" );
 	              Scanner in=new Scanner(System.in); 
 	             String inputPerson=in.nextLine();
 	    		try	{
 	    			person=Integer.parseInt(inputPerson);
 	    			}
 	    		catch(NumberFormatException nfe) {
 	    			System.out.println("please input the index number");
 	    			continue;
 	    		}
	                   if(person>=1 && person<=game.charPawn.size()){
	                     break;
		            }
		}
	    System.out.println("with what weapon?");
	    for(int t=0;t<game.weaponPawn.size();t++){  
             System.out.println((t+1)+") "+game.weaponPawn.get(t).getName());  
                                                  } 
	    while(true){
	            Scanner sc=new Scanner(System.in); 
	            String inputWeapon=sc.nextLine();
	    		try	{
	    			weapon=Integer.parseInt(inputWeapon);
	    			}
	    		catch(NumberFormatException nfe) {
	    			System.out.println("please input the index number");
	    			continue;
	    		}
	           if(weapon>=1 && weapon<=game.weaponPawn.size()){
	                     break;
	                }
	   }
	     //get position of the player//
	     keyword.add(game.charPawn.get(person-1).getName());
	     keyword.add(game.weaponPawn.get(weapon-1).getName());
	     keyword.add(board.findRoomName(X.character.getPosition()));
	    X.notebook.add("I formulated the hypothesis that "+keyword.get(0)+" made the murder in the"+keyword.get(2)+" with the "+keyword.get(1)+"\n");
 	    //find out the index of X
	    for(int t=0;t<game.users.size();t++){
	    	if(game.users.get(t).equals(X)){
	    		x=t;
	    	}
	    }
 	    //find out the related cards//
	    for(int t=0;t<3;t++){
	 	      cardIndex[t]=game.findCard(keyword.get(t));
	    }
	    boolean found=false;
	    outerloop:
	    for(int t=x+1;t<game.users.size();t++){
	    	for(int i=0;i<cardIndex.length;i++){
	    	if(game.findHolder(game.allCard.get(cardIndex[i]))==t){
	    		game.users.get(t).notebook.add(X.getName()+" formulated the hypothesis that "+keyword.get(0)+"  made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
		         game.users.get(t).notebook.add("I refuted the hypothesis by showing card "+game.allCard.get(cardIndex[i]).getName()+"\n");
		         game.users.get(t).notebook.add("*****************");
		            X.notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing the card "+keyword.get(t)+"\n");
		            X.notebook.add("*****************");
    	              for(int j=0;j<game.users.size();j++){
    		             if(j!=x && j!=t){
    			            game.users.get(j).notebook.add(X.getName()+" made the hypothesis that "+keyword.get(0)+" made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
    			            game.users.get(j).notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing a card\n");
    		                game.users.get(j).notebook.add("*****************");
    		}
    	}
    	              found=true;
    	              break outerloop;
    	             }
	    	} 
	    	         
	    } 
	    if(found==false){
	    	outerloop:
	    for(int t=0;t<x;t++){
	    	for(int i=0;i<cardIndex.length;i++){
		    	if(game.findHolder(game.allCard.get(cardIndex[i]))==t){
		    		game.users.get(t).notebook.add(X.getName()+" formulated the hypothesis that "+keyword.get(0)+"  made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
			         game.users.get(t).notebook.add("I refuted the hypothesis by showing card "+game.allCard.get(cardIndex[i]).getName()+"\n");
			         game.users.get(t).notebook.add("*****************");
			            X.notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing the card "+keyword.get(t)+"\n");
			            X.notebook.add("*****************");
	    	              for(int j=0;j<game.users.size();j++){
	    		             if(j!=x && j!=t){
	    			            game.users.get(j).notebook.add(X.getName()+" made the hypothesis that "+keyword.get(0)+" made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
	    			            game.users.get(j).notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing a card\n");
	    		                game.users.get(j).notebook.add("*****************");
	    		}
	    	}
	    	              found=true;
	    	              break outerloop;
	    }
		    	
	    	}  	}
	   
	    	}
	    keyword.remove(game.charPawn.get(person-1).getName());
	    keyword.remove(game.weaponPawn.get(weapon-1).getName());
	    keyword.remove(board.findRoomName(X.character.getPosition()));
	    System.out.println("You have finished the hypothesis");
	    	}
	    	  
	

	public void movePawn( Pawn pawn, int newPosition) {
		pawn.setPosition(newPosition);
	}
	
	
}


