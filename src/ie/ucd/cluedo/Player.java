package ie.ucd.cluedo;

import java.awt.BorderLayout;
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
import javax.swing.JComboBox;
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
	protected String person;
    protected String weapon;
    protected String room;
    public Player player;
    public Game game;
    public Board board;
    public Hypothesis hypo;
    
    public JFrame hy;
	public JButton bacu;
	public JPanel p, p0acu, p1acu,p2;
    public JComboBox<String> c0,c1;
    public JLabel l,l0,l1;
    
    public JFrame window=new JFrame("windows for "+this.getName());
	public JPanel p0win=new JPanel();
	public JLabel l0win=new JLabel("click here to view your cards");
	public JButton b0win=new JButton("view cards");
	public JPanel p1win=new JPanel();
	public JLabel l1win=new JLabel("click here to view your notebook");
	public JButton b1win=new JButton("view notebook");
	public JPanel p2win=new JPanel();
	public JLabel l2win=new JLabel("click here to make accusation");
	public JButton b2win=new JButton("make accusation");
	public JPanel p3win=new JPanel();
	public JLabel l3win=new JLabel("click here to make hypothesis");
	public JButton b3win=new JButton("make hypothesis");
	public JPanel p4win=new JPanel();
	public JButton b4win=new JButton("exit");
	
	/*public JFrame move0=new JFrame("movement for "+this.getName());
	public JPanel p0mov=new JPanel();
	public JLabel l0mov=new JLabel("click here to roll the dice");
	public JButton b0mov=new JButton("roll");
	
	public JFrame mov1=new JFrame("make movement");
	public JPanel p1mov=new JPanel();
	public JComboBox cmov=new JComboBox();
	public JLabel l1mov=new JLabel("Where do you want to go");*/
	
	
	boolean raise=false;
    
	
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
	
	

    public void raiseAccusation(){
    	accusationWords = new ArrayList<String>();
		hy=new JFrame("Making accusation");
		bacu=new JButton("done");
		bacu.addActionListener(this);
		l=new JLabel("your current location is "+room);
		p=new JPanel();
		p.add(l);
		l0=new JLabel("Who do you think would be the suspect?");
		c0=new JComboBox<String>();
        c0.setEditable(false);
		for(int t=0;t<game.charPawn.size();t++){
		c0.addItem(game.charPawn.get(t).getName());  
		}
		l1=new JLabel("With what weapon?");
		c1=new JComboBox<String>();
        c1.setEditable(false);
		for(int t=0;t<game.weaponPawn.size();t++){
		c1.addItem(game.weaponPawn.get(t).getName());  
		}
		p0acu = new JPanel();
        p0acu.setLayout(new BorderLayout());
        p0acu.add("West", l0);
        p0acu.add("East", c0);
       
        
        p1acu = new JPanel();
        p1acu.setLayout(new BorderLayout());
        p1acu.add("West", l1);
        p1acu.add("East", c1);
        
        p2=new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        p2.add(p);
        p2.add(p0acu);
        p2.add(p1acu);
        p2.add(bacu);
        
        hy=new JFrame();
        hy.add(p2);
	    hy.addWindowListener(new Hypothesis());
	    hy.setSize(1000, 1000);
	    hy.setVisible(true);
	    hy.pack();
    }
    
    public void processAccusation(){
    	raise=true;
    	int suspect=0;
    	int weaponIndex=0;
	    
    	int choice = JOptionPane.showConfirmDialog(null,"If the accusation is wrong, you will be removed from the game, are you still going on?","Important!!!",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
    	if(choice==JOptionPane.YES_OPTION){
    		 //find out the index of suspects
    		notebook.add("I formulated the accusation that"+person+" made the murder in the "+board.findRoomName(character.getPosition())+" with the"+weapon);
    		for(int t=0;t<game.charPawn.size();t++){
    	    	if(game.charPawn.get(t).getName()==person){
    	    		suspect=t;
    	    	}
    	    }
    	    //find out the index of the weapon
    	    for(int t=0;t<game.weaponPawn.size();t++){
    	    	if(game.weaponPawn.get(t).getName()==weapon){
    	    		weaponIndex=t;
    	    	}
    	    }
    		game.charPawn.get(suspect).setPosition(this.character.getPosition());
    	    game.weaponPawn.get(weaponIndex).setPosition(this.character.getPosition());
    		    if(game.mystery.get(0).getName().equals(accusationWords.get(0)) && game.mystery.get(1).getName().equals(accusationWords.get(0)) && game.mystery.get(2).getName().equals(accusationWords.get(1))){
    			   JOptionPane.showMessageDialog(null, "Congratulations! You got the correct answer !", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
    			   game.solved=true;
    		        }
    			else{
    				//game.users.remove(this);
    				this.playing=false;
    				JOptionPane.showMessageDialog(null, "Sorry, you did not get the correct answer", "You are out!", JOptionPane.INFORMATION_MESSAGE);
    				JOptionPane.showMessageDialog(null, "you have been removed", "You are out!", JOptionPane.INFORMATION_MESSAGE);
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
    			raise=false;
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
						character.setPosition(pos-amount % 54);
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
						character.setPosition(pos+amount % 54);
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
			

	/*	public void choice(Game game,Hypothesis hepo, Board board) {
			hypo=hepo;
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
					if (pos==0 || pos==6 ||pos==12 ||pos==18 ||pos==24 ||pos==30 ||pos==36 ||pos==42 ||pos==48) {
				         raiseAccusation();
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
		*/
      public void printNotebook(){
    	  notes=new JFrame("notebook of "+this.getName());
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
/*	public void checkNotebook(){
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
	*/
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
		cards=new JFrame("cards for "+this.getName());
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
	public void buildWindow(Game game, Board board, Hypothesis hepo){
		this.game=game;
		this.board=board;
		this.hypo=hepo;
		raise=false;
		room=board.findRoomName(character.getPosition());
		JLabel l00=new JLabel("Welcome to room " + room );
		JPanel p00=new JPanel();
		p00.add(l00);
		window=new JFrame("windows for "+this.getName());
		p0win.add(l0win);
		p0win.add(b0win);
		p1win.add(l1win);
		p1win.add(b1win);
		p2win.add(l2win);
		p2win.add(b2win);
		p3win.add(l3win);
		p3win.add(b3win);
		p4win.add(b4win);
		b0win.addActionListener(this);
		b1win.addActionListener(this);
		b2win.addActionListener(this);
		b3win.addActionListener(this);
		b4win.addActionListener(this);
		
		JPanel pc=new JPanel();
		pc.setLayout(new BoxLayout(pc, BoxLayout.Y_AXIS));
		pc.add(p00);
		pc.add(p0win); 
		pc.add(p1win); 
		pc.add(p3win); 
		pc.add(p2win);
		pc.add(p4win);
		window.add(pc);
		window.addWindowListener(new Player(""));
	    window.setSize(1000, 1000);
	    window.setVisible(true);
	    window.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 
		 int pos=this.character.getPosition();
		if(e.getSource() == b0){
			 notes.setVisible(false); 
	        }// TODO Auto-generated method stub
		 if(e.getSource() == b1){
			 cards.setVisible(false);
		 }
		 if(e.getSource()==bacu){
			 person=(String) c0.getSelectedItem();
	         weapon=(String) c1.getSelectedItem();
			 accusationWords.add(person);
             accusationWords.add(weapon);
             accusationWords.add(room);
             hy.setVisible(false);
        	 processAccusation();
		 }
		 if(e.getSource()==b0win){
			 printCard();
		 }
		 if(e.getSource()==b1win){
			 printNotebook();
		 }
		 if(e.getSource()==b2win){
			 if((raise==false) && (pos==0 || pos==6 ||pos==12 ||pos==18 ||pos==24 ||pos==30 ||pos==36 ||pos==42 ||pos==48)){
				 raiseAccusation();
				 }
				 else{
					 JOptionPane.showMessageDialog(null, "you cannot raise an accusation here", " ", JOptionPane.INFORMATION_MESSAGE);
				 }
			
		 }
		 if(e.getSource()==b3win){
			 if((raise==false) && (pos==0 || pos==6 ||pos==12 ||pos==18 ||pos==24 ||pos==30 ||pos==36 ||pos==42 ||pos==48)){
			 hypo.makeHypothesis(this, game, board);
			 }
			 else{
				 JOptionPane.showMessageDialog(null, "you cannot raise a hypothesis here", " ", JOptionPane.INFORMATION_MESSAGE);
			 }
		 }
		 if(e.getSource()==b4win){
			 int choice = JOptionPane.showConfirmDialog(null,"Have you finished all the movement for this turn?"," ",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
		    	if(choice==JOptionPane.YES_OPTION){ 
		    		game.wait=false;
		    		window.setVisible(false);
			        game.startGame(hypo, board);
		    	}
		    	if(choice==JOptionPane.NO_OPTION){
		    		
		    	}
		 }
	}
		
}
		
		
		
		
		