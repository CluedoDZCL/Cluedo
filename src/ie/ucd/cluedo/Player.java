package ie.ucd.cluedo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class Player extends WindowAdapter implements ActionListener {
	public String name;
	protected List<String> notebook;
	protected List<Card> playerCards;
	public Pawn character;
	public List<String>accusationWords;
	public boolean playing;
	public JFrame notes;
	public JFrame cards;
	public JButton b0;
	public JButton b1;
	public JPanel p0, p1;
	
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
	
	

    public void raiseAccusation(Game game, Board board){
    	accusationWords = new ArrayList<String>();
    	int person=0;
    	int weapon=0;
    	for(int t=0;t<game.charPawn.size();t++){  
	           System.out.println((t+1)+") "+game.charPawn.get(t).getName());  
	       } 
	while(true){
		       System.out.println("who do you accuse could be the killer?" );
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
	    			System.out.println("please input the correct index");
	    			continue;
	    		}
	           if(weapon>=1 && weapon<=game.weaponPawn.size()){
	                      break;
	                 }
	     }
	             accusationWords.add(game.charPawn.get(person-1).getName());
	             accusationWords.add(game.weaponPawn.get(weapon-1).getName());
	             accusationWords.add(board.findRoomName(this.character.getPosition()));
    	notebook.add("I formulated the accusation that"+person+" made the murder in the"+character.getPosition()+" with the"+weapon);
    	int choice = JOptionPane.showConfirmDialog(null,"Important!!!","If the accusation is wrong, you will be removed from the game, are you still going on?",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
    	if(choice==JOptionPane.YES_OPTION){
    		    if(game.mystery.get(0).getName().equals(accusationWords.get(0)) && game.mystery.get(1).getName().equals(accusationWords.get(0)) && game.mystery.get(2).getName().equals(accusationWords.get(1))){
    			   JOptionPane.showMessageDialog(null, "Congratulations! You got the correct answer !", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
    			   game.solved=true;
    		        }
    			else{
    				//game.users.remove(this);
    				this.playing=false;
    				JOptionPane.showMessageDialog(null, "Sorry, you did not get the correct answer", "You are out!", JOptionPane.INFORMATION_MESSAGE);
    	               for(int j=0;j<game.users.size();j++){
    	     		       if(!game.users.get(j).getName().equals(this) ){
    	     			       game.users.get(j).notebook.add(this.getName()+" has been removed from the game\n");
    	     			       game.users.get(j).notebook.add("*****************");
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
		int dice1 = rand.nextInt(6)+1;
		int dice2 = rand.nextInt(6)+1;
		int diceroll=dice1+dice2;
		int resp1;
		int amount=0;
		System.out.println("you have rolled a " + diceroll );
				
		while(true) {

			if (pos==6 || pos==24 || pos==36 || pos==48) {
				System.out.println("Would you like to, \n 1) move anticlockwise \n 2) move clockwise \n 3) stay \n 4)shortcut");
				Scanner in=new Scanner(System.in);
				String input=in.nextLine();
				try	{
					resp1=Integer.parseInt(input);
					}
				catch(NumberFormatException nfe) {
					System.out.println("please input the correct index number");
					continue;
				}
			}
			else {
				System.out.println("Would you like to, \n 1) move anticlockwise \n 2) move clockwise \n 3) stay");
				Scanner in=new Scanner(System.in);
				String input=in.nextLine();
				try	{
					resp1=Integer.parseInt(input);
					}
				catch(NumberFormatException nfe) {
					System.out.println("please input the correct index number");
					continue;
				}
			}
			
			
			if(resp1==3) {
				break;
			}
			else if(resp1==1){
				while(true) {
					System.out.println("How many steps do you want to go?");
					Scanner resp2=new Scanner(System.in);
					String respTwo=resp2.nextLine();
					try	{
						amount=Integer.parseInt(respTwo);
						}
					catch(NumberFormatException nfe) {
						System.out.println("please input a number");
						continue;
					}
					if (amount<=diceroll) {
						character.setPosition(pos-amount % 100);
						break;
					}
				}
				break;
			}
			else if(resp1==2){
				while(true) {
					System.out.println("How many steps do you want to go?");
					Scanner resp2=new Scanner(System.in);
					String respTwo=resp2.nextLine();
					try	{
						amount=Integer.parseInt(respTwo);
						}
					catch(NumberFormatException nfe) {
						System.out.println("please input a number");
						continue;
					}
					if (amount<=diceroll) {
						character.setPosition(pos+amount % 100);
						break;
					}
				}
				break;
			}
			else if(resp1==4){
				while(true) {
					if 		(pos==6)	character.setPosition(36);
					else if (pos==24)	character.setPosition(48);
					else if (pos==36)	character.setPosition(6);
					else if (pos==48)	character.setPosition(24);
					break;
					}
				}
				break;
			}
		}
			

		public void choice(Game game,Hypothesis hepo, Board board) {
			while(true) {
				int resp;
				int pos=character.getPosition();
				System.out.println("Now you are in the "+board.findRoomName(pos));
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
				
				if (resp==1) {
				raiseAccusation(game, board);
				break;
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
		
      public void printNotebook(){
    	  notes=new JFrame("notebook content");
    	  p0=new JPanel();
    	  b0=new JButton("done");
    	  b0.addActionListener(this);
    	  p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));
    	  for(int t=0;t<notebook.size();t++){  
    		  JLabel l= new JLabel(notebook.get(t));
    		  JLabel l1=new JLabel("\n");
    		  l.setHorizontalAlignment(JLabel.CENTER);
    		  l1.setHorizontalAlignment(JLabel.CENTER);
    		  p0.add(l);
    		  p0.add(l1);
	       }
    	  p0.add(b0);
    	  notes.add(p0);
 	     notes.addWindowListener(new Player(""));
 	     notes.setSize(1000, 1000);
 	     notes.setVisible(true);
 	     notes.pack();
      }
	public void checkNotebook(){
		int check;
		while(true){
		System.out.println("Do you want to check your notebook \n 1) yes; \n 2) no;");
		Scanner ck=new Scanner(System.in);
		String ckc=ck.nextLine();
		try	{
			check=Integer.parseInt(ckc);
			}
		catch(NumberFormatException nfe) {
			System.out.println("please input a number");
			continue;
		}
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
	public void checkCard(){
		int check;
		while(true){
		System.out.println("Do you want to check your cards \n 1) yes; \n 2) no;");
		Scanner ck=new Scanner(System.in);
		String ckc=ck.nextLine();
		try	{
			check=Integer.parseInt(ckc);
			}
		catch(NumberFormatException nfe) {
			System.out.println("please input a number");
			continue;
		}
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
	}}
	public void printCard(){
		cards=new JFrame("cards content");
  	    p1=new JPanel();
  	    b1=new JButton("done");
  	    b1.addActionListener(this);
  	    p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
  	  for(int t=0;t<playerCards.size();t++){  
  		  JLabel l= new JLabel(playerCards.get(t).getName());
  		  l.setHorizontalAlignment(JLabel.CENTER);
	      JLabel l1=new JLabel("\r");
	      l1.setHorizontalAlignment(JLabel.CENTER);
  		  p1.add(l);
  		  p1.add(l1);
	       }
  	    p1.add(b1);
  	    cards.add(p1);
	     cards.addWindowListener(new Player(""));
	     cards.setSize(1000, 1000);
	     cards.setVisible(true);
	     cards.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource() == b0){
			 notes.setVisible(false); 
	        }// TODO Auto-generated method stub
		 if(e.getSource() == b1){
			 cards.setVisible(false);
		 }
	}
		
}
		
		
		
		
		