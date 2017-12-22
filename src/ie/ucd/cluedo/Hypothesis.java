package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * This class represents Hypothesis
 * It organizes raising the hypothesis
 * It prints the appropriate statements in notebooks
 */

public class Hypothesis {
    protected List<String> keyword; // the list of the three elements, suspect, weapon and room
    int suspect;// input suspect index from the player
    int weaponIndex;//input suspect index from the player
    int cardIndex[]=new int[3];//the element cards index in the cards list
    int x; //the players position in the user list
    boolean found; 
	
    public Hypothesis(){
		keyword=new ArrayList<String>();
	}
	
    public void makeHypothesis(Player X, Game game, Board board){
    		raiseHypothesis(X, game, board);
    		initialElements(X, game, board,suspect, weaponIndex);
    		processHypothesis(X, game, board);
    		endHypothesis(X, game,board);
    }
    public int scanSuspect(){
		int suspect;
		System.out.println("Who do you guess would be the suspect?");
		Scanner sc=new Scanner(System.in);
		String inputIndex=sc.nextLine();
		try{
		    suspect=Integer.parseInt(inputIndex);
			if (suspect>=1 && suspect<=6) {
				  return suspect; 
			   }
			   else return -1;
			}
		   catch(NumberFormatException nfe) {
			  return -1;
			  }
	}
	
	public int scanWeapon(){
		int weapon;
		System.out.println("with what weapon?");
		Scanner sc=new Scanner(System.in);
		String weaponIndex=sc.nextLine();
		try{
		    weapon=Integer.parseInt(weaponIndex);
			if (weapon>=1 && weapon<=6) {
				  return weapon; 
			   }
			   else return -1;
			}
		   catch(NumberFormatException nfe) {
			  return -1;
			  }
	}
    
    public void raiseHypothesis(Player X, Game game, Board board){
	        while(true){
		    	System.out.println("Who do you guess would be the suspect?");
		    	// print out the character list
		    	for(int t=0;t<game.charPawn.size();t++){
		    		System.out.println((t+1)+"."+game.charPawn.get(t).getName());
		    	}
		    	System.out.println("Please input the suspect index");
		    	//get the input from the commend panel
		    	suspect=scanSuspect();
					//if the suspect index is correct
					if(suspect!=-1){
						//input the weapon
						while(true){
							System.out.println("with what weapon?");
					    	for(int t=0;t<game.weaponPawn.size();t++){
					    		System.out.println((t+1)+"."+game.weaponPawn.get(t).getName());
					    	}
					    	System.out.println("Please input the weapon index");
					    	weaponIndex=scanWeapon();
							//if the weapon is correct
							if(weaponIndex!=-1){
								found=false;//the hypothesis is finished, but the related card has not been found
								break;  
	                         }
							//if the weapon is not correct, it will go back to require another input
							else{
								continue;
							}
						}
					}
					//if the suspect is not correct, it will go back to require another input
					else{
						continue;
					}
					break;
	        }      
	}
    
	 public void processHypothesis(Player X, Game game, Board board){
		   //start search the related card from the previous player
		     outerloop:
             for(int t=x-1;t>=0;t--){
                 for(int i=0;i<cardIndex.length;i++){
	                 if((game.users.get(t).playing==true) && (game.findHolder(game.allCard.get(cardIndex[i]))==t)){
	                     game.users.get(t).notebook.add(X.getName()+" formulated the hypothesis that "+keyword.get(0)+"  made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
	                     game.users.get(t).notebook.add("I refuted the hypothesis by showing card "+game.allCard.get(cardIndex[i]).getName()+"\n");
	                     game.users.get(t).notebook.add("************************************************************");
	                     X.notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing the card "+game.allCard.get(cardIndex[i]).getName()+"\n");
	                     X.notebook.add("************************************************************");
	                     JOptionPane.showMessageDialog(null, game.users.get(t).getName()+" refuted the hypothesis by showing the card "+game.allCard.get(cardIndex[i]).getName(), "", JOptionPane.INFORMATION_MESSAGE); 
	                     //print out the event on others notebooks
	                     for(int j=0;j<game.users.size();j++){
	                         if(j!=x && j!=t){
	                            game.users.get(j).notebook.add(X.getName()+" made the hypothesis that "+keyword.get(0)+" made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
	                            game.users.get(j).notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing a card\n");
	                            game.users.get(j).notebook.add("************************************************************");
	                            }
	                      }
	                     found=true;//if the holder has been found, the flag should be true
	                     break outerloop;//as long as finding out the first card holder then exit the loop
	                  }
	               } 
	           }
	         //if the card holder has not been found, then start searching from the end player to the player X+1
	         if(found==false){
	            outerloop:
	            for(int t=game.users.size()-1;t>=x+1;t--){
	                for(int i=0;i<cardIndex.length;i++){
	                    if((game.users.get(t).playing==true) && (game.findHolder(game.allCard.get(cardIndex[i]))==t)){
	                        game.users.get(t).notebook.add(X.getName()+" formulated the hypothesis that "+keyword.get(0)+"  made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
	                        game.users.get(t).notebook.add("I refuted the hypothesis by showing card "+game.allCard.get(cardIndex[i]).getName()+"\n");
	                        game.users.get(t).notebook.add("************************************************************");
	                        X.notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing the card "+game.allCard.get(cardIndex[i]).getName()+"\n");
	                        X.notebook.add("************************************************************");
	                        JOptionPane.showMessageDialog(null, game.users.get(t).getName()+" refuted the hypothesis by showing the card "+game.allCard.get(cardIndex[i]).getName(), "", JOptionPane.INFORMATION_MESSAGE); 
	                        //print out the event on others notebooks
	                        for(int j=0;j<game.users.size();j++){
	                            if(j!=x && j!=t){
	                               game.users.get(j).notebook.add(X.getName()+" made the hypothesis that "+keyword.get(0)+" made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
	                               game.users.get(j).notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing a card\n");
	                               game.users.get(j).notebook.add("************************************************************");
	                            }
	                         }
	                     found=true;//the card holder has been found
	                     break outerloop;
	                     }
	                 }
	              }
	           }
	       //if nothing has been found after two round searching, which mean the hypothesis might be correct
	         if(found==false){
	             X.notebook.add("Nothing has been found !");
	             JOptionPane.showMessageDialog(null, "Nothing has been found", "", JOptionPane.INFORMATION_MESSAGE);
	           }
	 }
	 
	 void endHypothesis(Player X, Game game, Board board){
	      //move the suspect and weapon pawns into the room
	        game.charPawn.get(suspect-1).setPosition(X.character.getPosition());
	        game.weaponPawn.get(weaponIndex-1).setPosition(X.character.getPosition());
	      //clear the record of the keyword
	        keyword.remove(game.charPawn.get(suspect-1).getName());
	        keyword.remove(game.weaponPawn.get(weaponIndex-1).getName());
	        keyword.remove(board.findRoom(X.character.getPosition()));
	 }   	  
                	
					
		public void initialElements(Player X, Game game, Board board, int suspect, int weaponIndex){
		  //define the three element in the hypothesis
			keyword.add(game.charPawn.get(suspect-1).getName());
			keyword.add(game.weaponPawn.get(weaponIndex-1).getName());
			keyword.add(board.findRoom(X.character.getPosition()));
            X.notebook.add("I formulated the hypothesis that "+keyword.get(0)+" made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
             //find out the index of X so that we could start searching from X-1
            for(int t=0;t<game.users.size();t++){
                if(game.users.get(t).equals(X)){
                   x=t;
                }
             }
          //find out the related cards//
            for(int t=0;t<3;t++){
            	cardIndex[t]=game.findCard(keyword.get(t)); //the index of the three cards in the allCards Array list
             }
		 }	
}
	        
	

		
	
	
	



