package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * This class represents a player
 * It organizes player movements and choices
 */

public class Player {
	public String name;
	protected List<String> notebook;
	protected List<Card> playerCards;
	public Pawn character;
	public boolean playing;
    
	public Player(String name){
		notebook=new ArrayList<String>();
		playerCards = new ArrayList<Card>();
		playing =true;
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public Pawn getCharacter() {
		return character;
	}
	
	
	public List<Card> getPlayerCards() {
		return playerCards;
	}
	
	public boolean contains(Card card) {
		boolean contains = false;
		for (int i=0; i< playerCards.size();i+=1) {
			if (playerCards.get(i).equals(card))
				contains = true;
		}
		return contains;
	}
	
	public int scanSuspectAccusation(){
		int suspect;
		System.out.println("Who do you think would be the suspect?");
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
	
	public int scanWeaponAccusation(){
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
	
	public void raiseAccusation(Game game, Board board){
    	int suspect=0;
    	//while loop is guarantee the input is between 1 and 6, if not it will go back and ask for another input
    	while(true){
	    	System.out.println("Who do you think would be the suspect?");
	    	for(int t=0;t<game.charPawn.size();t++){
	    		System.out.println((t+1)+"."+game.charPawn.get(t).getName());
	    	}
	    	System.out.println("Please input the suspect index");
	    	suspect=scanSuspectAccusation();
			//if the suspect index is correct, then go to the next step
	    	if(suspect!=-1){
	    		requireWeapon(game, board, suspect);
			    }
			else{
				continue;
				}
			break;
    	}
    }
	public void requireWeapon(Game game, Board board, int suspect){
		 int weapon=0;
		 //contain the three element in an accusation
		 while(true){
	          System.out.println("with what weapon?");
	          for(int t=0;t<game.weaponPawn.size();t++){
			  System.out.println((t+1)+"."+game.weaponPawn.get(t).getName());
		}
			  System.out.println("Please input the weapon index");
			  weapon=scanWeaponAccusation();
			//if the weapon index is correct then start process the accusation
			  if(weapon!=-1){
				 processAccusation(game,board,suspect, weapon);
				 break;
			   }
			  else{
				   continue;
			   }
	   }
}

		 public void processAccusation(Game game, Board board, int suspect, int weapon){
				//confirm the accusation
				  int choice = JOptionPane.showConfirmDialog(null,"If the accusation is wrong, you will be removed from the game, are you still going on?","Important!!!",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
				  if(choice==JOptionPane.YES_OPTION){
					 notebook.add("I formulated the accusation that"+game.charPawn.get(suspect-1).getName()+" made the murder in the "+board.findRoom(this.character.getPosition())+" with the"+game.weaponPawn.get(weapon-1).getName());
					//move the suspect and the weapon into the room
					 game.charPawn.get(suspect-1).setPosition(this.character.getPosition());
					 game.weaponPawn.get(weapon-1).setPosition(this.character.getPosition());
					//compare the accusation and the correct answer
					 if(game.checkMystery(game.charPawn.get(suspect-1).getName(),board.findRoom(this.character.getPosition()), game.weaponPawn.get(weapon-1).getName())==true){
					    JOptionPane.showMessageDialog(null, "Congratulations! You got the correct answer !", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
					    game.mysterySolved();
					  }
					 else{
					    this.playing=false;//this player could not keep playing the game
					    JOptionPane.showMessageDialog(null, "Sorry, you did not get the correct answer", "You are out!", JOptionPane.INFORMATION_MESSAGE);
					    JOptionPane.showMessageDialog(null, "you have been removed", "You are out!", JOptionPane.INFORMATION_MESSAGE);
					    for(int j=0;j<game.users.size();j++){
					    	if(!game.users.get(j).equals(this) ){
					    	   game.users.get(j).notebook.add(this.getName()+" has been removed from the game\n");
					    	   game.users.get(j).notebook.add("************************************************************");
					    	 }
					    }
					  }
					}
				   if(choice==JOptionPane.NO_OPTION){
				      JOptionPane.showMessageDialog(null, "You stopped the accusation.", "Game goes on", JOptionPane.INFORMATION_MESSAGE);
				    }
	}	
    
    
     public void movement(){
		int pos=character.getPosition();
		Random rand = new Random();
		int dice1 = rand.nextInt(6)+1;//randomly get a number between 1 and 6
		int dice2 = rand.nextInt(6)+1;
		int diceroll=dice1+dice2;
		int amount=0;
		System.out.println("you have rolled a " + diceroll );
				
		while(true) {
            //if the player's character pawn is in the room with shortcut, they could choose to move directly through shortcut
			if (pos==6 || pos==24 || pos==36 || pos==48) {
				if (scanShortcut()) {
					if 		(pos==6) {
						character.setPosition(36);//their position number is the same as the related room number
						break;
					}
					else if (pos==24) {
						character.setPosition(48);
						break;
					}
					else if (pos==36) {
						character.setPosition(6);
						break;
					}
					else if (pos==48) {
						character.setPosition(24);		
						break;
					}
				}
			}
			
			//returns response: Would you like to, \n 1) move anticlockwise \n 2) move clockwise \n 3) stay
			int choice=moveChoice();

			//they choose to stay
			if(choice==3) {
				break;	
				}
			//they chose to move backward
			else if(choice==1){
				amount=steps(diceroll);
				character.setPosition(pos-amount);//they will be moved to the related place
				break;
				}
			//they choose to move forward
			else if(choice==2){
				amount=steps(diceroll);
				character.setPosition(pos+amount);
				break;
				}
		}
     }
     
     //Prompts the user to give amount they wish to move by
     public int steps(int diceroll) {
    	 int amount;
    	 System.out.println("How many steps do you want to go?");
    	 while(true) { 
    		 Scanner resp2=new Scanner(System.in);
    		 String respTwo=resp2.nextLine();
    				try	{
    					amount=Integer.parseInt(respTwo);
    					}
    				catch(NumberFormatException nfe) {
    					System.out.println("please input a number");
    					amount=-1;
    					}
    		if (checkDiceroll(amount, diceroll)) break;
    	 }
    	 return amount;
     }
     
     //ensures the move amount does not excede the diceroll
     public boolean checkDiceroll(int amount, int diceroll) {
    	 if (amount<=diceroll && amount>0) return true;
    	 else {
    		 System.out.println("please input a valid number, you rolled a"+ diceroll);
    		 return false;
    	 }
     }
     
     //prompts the user to check if they wish to use shortcut
     public boolean scanShortcut() {
    	 int resp=0;
    	 System.out.println("Would you like to use shortcut? \n 1) Yes \n 2) No");
    	 while(true) {
	    	 Scanner in=new Scanner(System.in);
	    	 String input=in.nextLine();
	    	 try{
	    		 resp=Integer.parseInt(input);
				}
			catch(NumberFormatException nfe) {
				System.out.println("please input the correct index number");
				}
			if (resp==1 || resp==2) {
				break;
			}
    	 }
    	 if (resp==1) return true;
    	 else return false;    			 
     }
     
    //checks the direction in which the user wants to move
     public int moveChoice() {
    	int resp=0;
    	System.out.println("Would you like to, \n 1) move anticlockwise \n 2) move clockwise \n 3) stay");
    	while(true) {
	 		Scanner in=new Scanner(System.in);
	 		String input=in.nextLine();
	 		try	{
	 			resp=Integer.parseInt(input);
	 			}
	 		catch(NumberFormatException nfe) {
	 	 		}
	 		if (resp==1 || resp==2 || resp==3) break;
	 		else System.out.println("please input the correct index number");
    	}
 		return resp;
     }
     
			
        //they could choose to raise hypothesis or accusation or do nothing
		public void choice(Game game,Hypothesis hepo, Board board) {
			while(true) {
				int resp;
				int pos=character.getPosition();
				System.out.println("Now you are in the "+board.findRoom(pos));//print the room name
				System.out.println("Would you like to, \n 1) make acusation \n 2) make hypothesis \n 3) end turn");
				Scanner in=new Scanner(System.in);
				String respOne=in.nextLine();
				try	{
					resp=Integer.parseInt(respOne);
					}
				catch(NumberFormatException nfe) {
					System.out.println("please input a number");
					continue;
				}
				//they choose to make accusation
				if (resp==1) {
				    //their positions should be the same as one of the room position
					if (pos==0 || pos==6 ||pos==12 ||pos==18 ||pos==24 ||pos==30 ||pos==36 ||pos==42 ||pos==48) {
				         raiseAccusation(game, board);
				       break;}
					else{
						System.out.println("You are not in a room");
					}
				}
				else if (resp==2) {
					if (pos==0 || pos==6 ||pos==12 ||pos==18 ||pos==24 ||pos==30 ||pos==36 ||pos==42 ||pos==48) {
						hepo.makeHypothesis(this, game, board);
						break;
					} else {
						System.out.println("You are not in a room");
					}
				}
				else if (resp==3) {
					break;
				}
			}
		}
	  //print their notebooks
      public void printNotebook(){
    	 JFrame notes=new JFrame("notebook of "+this.getName());
    	 JPanel p0=new JPanel();
    	 p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));//set the layout of the panel
    	//create a new label for every new string and put it in the panel
    	 for(int t=0;t<notebook.size();t++){  
    		 JLabel l= new JLabel(notebook.get(t));
    		
    		 JLabel l1=new JLabel("\n");
    		 l.setHorizontalAlignment(JLabel.CENTER);
    		 l1.setHorizontalAlignment(JLabel.CENTER);
    		 
    		 
    		 p0.add(l);
    		 p0.add(l1);
	       }
    	 JScrollPane jsp=new JScrollPane(p0);
   
		 notes.add(jsp); 
 	     notes.setSize(1000, 1000);
 	     notes.setVisible(true);
 	     notes.pack();
      }
    //ask if the players want to print their notebook
      public int scanCheckNotebook(){
  		int checknotebook;
  		Scanner sc=new Scanner(System.in);
  		String checkIndex=sc.nextLine();
  		try{
  		    checknotebook=Integer.parseInt(checkIndex);
  			if (checknotebook>=1 && checknotebook<=2) {
  				  return checknotebook; 
  			   }
  			   else return -1;
  			}
  		   catch(NumberFormatException nfe) {
  			  return -1;
  			  }
  	}
      public void checkNotebook(){
		int check;
		while(true){
		      System.out.println("Do you want to check your notebook \n 1) yes; \n 2) no;");
		      check=scanCheckNotebook();
		      if(check==1){
		    	  printNotebook();
		    	  break;
		      }
		      if(check==2){
		    	  break;
		      }
		      if(check!=1 && check!=2){
		    	  System.out.println("please input the correct index");
		    	  continue;
		      }
		}	
	}
	
	public void initializeNotebook(){
		notebook.add("************************************************************");
		notebook.add("Game Start");
		notebook.add("************************************************************");
	}	
	//check if they want to print out their cards
	public int scanCheckCard(){
		int check;
		Scanner sc=new Scanner(System.in);
		String checkIndex=sc.nextLine();
		try{
		    check=Integer.parseInt(checkIndex);
			if (check>=1 && check<=2) {
				  return check; 
			   }
			   else return -1;
			}
		   catch(NumberFormatException nfe) {
			  return -1;
			  }
	}
	public void checkCard(){
		int check;
		while(true){
			System.out.println("Do you want to check your cards \n 1) yes; \n 2) no;");
			check=scanCheckCard();
			if(check==1){
				printCard();
				break;
			}
			if(check==2){
				break;
			}
			if(check!=1 && check!=2){
				System.out.println("please input the correct index");
				continue;
			}	
	   }
	}

	public void printCard(){
		JFrame cards=new JFrame("cards for "+this.getName());
  	    JPanel p1=new JPanel();
  	    p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
  	    for(int t=0;t<playerCards.size();t++){  
  	    	JLabel l= new JLabel(playerCards.get(t).getName());
  	    	l.setHorizontalAlignment(JLabel.CENTER);
  	    	JLabel l1=new JLabel("\r");
  	    	l1.setHorizontalAlignment(JLabel.CENTER);
  	    	p1.add(l);
  	    	p1.add(l1);
	       	}
  	    cards.add(p1);
	    cards.setSize(1000, 1000);
	    cards.setVisible(true);
	    cards.pack();
	}
}
		
		
		
		
		