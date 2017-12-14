package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Hypothesis {
    protected List<String> keyword; // the list of the three elements, sspect, weapon and room
    
    
    
	public Hypothesis(){
		keyword=new ArrayList<String>();
	}
	
	public void makeHypothesis(Player X, Game game, Board board){
		    int suspect = 0;
	        int weaponIndex=0;
	        int cardIndex[]=new int[3];//the element cards index in the cards list 
	    	int x=0;
	        while(true){
		    	System.out.println("Who do you guess would be the suspect?");
		    	// print out the character list
		    	for(int t=0;t<game.charPawn.size();t++){
		    		System.out.println((t+1)+"."+game.charPawn.get(t).getName());
		    	}
		    	System.out.println("Please input the suspect index");
		    	//get the input from the commend panel
		    	Scanner susp=new Scanner(System.in);
		    	 String suspIndex=susp.nextLine();
					try	{
						suspect=Integer.parseInt(suspIndex);//the input should be a integer, if it is an integer the program will process it
						}
					catch(NumberFormatException nfe) {
						System.out.println("please input the index number");//if the input is a string, the program will go back to the loop to let the user re input the index
						continue;
					}
					//if the suspect index is correctly between 1 and 6 then go to the next step
					if(suspect>0 && suspect <7){
						//input the weapon
						while(true){
							System.out.println("with what weapon?");
					    	for(int t=0;t<game.weaponPawn.size();t++){
					    		System.out.println((t+1)+"."+game.weaponPawn.get(t).getName());
					    	}
					    	System.out.println("Please input the weapon index");
					    	Scanner weap=new Scanner(System.in);
					    	 String weapIndex=weap.nextLine();
								try	{
									weaponIndex=Integer.parseInt(weapIndex);
									}
								catch(NumberFormatException nfe) {
									System.out.println("please input the index number");
									continue;
								}
							//if the weapon is correctly between 1 and 6 then go to the next step: hypothesis processing
							if(weaponIndex>0 && weaponIndex<7){
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
	                            boolean found=false;
	                            //start searching from X-1 to 0;
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
	                           //move the suspect and weapon pawns into the room
	                            game.charPawn.get(suspect-1).setPosition(X.character.getPosition());
	                            game.weaponPawn.get(weaponIndex-1).setPosition(X.character.getPosition());
	                           //clear the record of the keyword
	                            keyword.remove(game.charPawn.get(suspect-1).getName());
	                            keyword.remove(game.weaponPawn.get(weaponIndex-1).getName());
	                            keyword.remove(board.findRoom(X.character.getPosition()));
	                            break;
							}
	    	  
						}
					}
					break;
	        }
	}
}
		
	
	
	



