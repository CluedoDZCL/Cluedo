package ie.ucd.cluedo;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hypothesis extends WindowAdapter implements ActionListener{
    protected List<String> keyword; // the list of the room name, weapon name, and person name
    protected String person;
    protected String weapon;
    protected String room;
    public Player player;
    public Game game;
    public Board board;
    int cardIndex[]=new int[3];
	int x=0;
    public JFrame hy;
	public JButton b0;
	public JPanel p, p0, p1,p2;
    public JComboBox<String> c0,c1;
    public JLabel l,l0,l1;
	public Hypothesis(){
		keyword=new ArrayList<String>();
	}
	
	public void makeHypothesis(Player X, Game game, Board board){
		player=X;
		this.game=game;
		this.board=board;
		room=board.findRoomName(X.character.getPosition());
		hy=new JFrame("Making hypothesis");
		b0=new JButton("done");
		b0.addActionListener(this);
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
		p0 = new JPanel();
        p0.setLayout(new BorderLayout());
        p0.add("West", l0);
        p0.add("East", c0);
       
        
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add("West", l1);
        p1.add("East", c1);
        
        p2=new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        p2.add(p);
        p2.add(p0);
        p2.add(p1);
        p2.add(b0);
        
        hy=new JFrame();
        hy.add(p2);
	    hy.addWindowListener(new Hypothesis());
	    hy.setSize(1000, 1000);
	    hy.setVisible(true);
	    hy.pack();
		}
		 
	
	    public void processHypothesis(){
	        int suspect = 0;
	        int weaponIndex=0;
	    	player.notebook.add("I formulated the hypothesis that "+keyword.get(0)+" made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
 	    //find out the index of X
	    for(int t=0;t<game.users.size();t++){
	    	if(game.users.get(t).equals(player)){
	    		x=t;
	    	}
	    }
	    //find out the index of suspects
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
 	    //find out the related cards//
	    for(int t=0;t<3;t++){
	 	      cardIndex[t]=game.findCard(keyword.get(t));
	    }
	    boolean found=false;
	    outerloop:
	    for(int t=x-1;t>=0;t--){
	    	for(int i=0;i<cardIndex.length;i++){
	    	if((game.users.get(t).playing==true) && (game.findHolder(game.allCard.get(cardIndex[i]))==t)){
	    		game.users.get(t).notebook.add(player.getName()+" formulated the hypothesis that "+keyword.get(0)+"  made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
		         game.users.get(t).notebook.add("I refuted the hypothesis by showing card "+game.allCard.get(cardIndex[i]).getName()+"\n");
		         game.users.get(t).notebook.add("************************************************************");
		            player.notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing the card "+game.allCard.get(cardIndex[i]).getName()+"\n");
		            player.notebook.add("************************************************************");
		            JOptionPane.showMessageDialog(null, game.users.get(t).getName()+" refuted the hypothesis by showing the card "+game.allCard.get(cardIndex[i]).getName(), "", JOptionPane.INFORMATION_MESSAGE); 
		            for(int j=0;j<game.users.size();j++){
    		             if(j!=x && j!=t){
    			            game.users.get(j).notebook.add(player.getName()+" made the hypothesis that "+keyword.get(0)+" made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
    			            game.users.get(j).notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing a card\n");
    		                game.users.get(j).notebook.add("************************************************************");
    		}
    	}
    	              found=true;
    	              break outerloop;
    	             }
	    	} 
	    	         
	    } 
	    if(found==false){
	    	outerloop:
	    for(int t=game.users.size()-1;t>=x+1;t--){
	    	for(int i=0;i<cardIndex.length;i++){
		    	if((game.users.get(t).playing==true) && (game.findHolder(game.allCard.get(cardIndex[i]))==t)){
		    		game.users.get(t).notebook.add(player.getName()+" formulated the hypothesis that "+keyword.get(0)+"  made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
			         game.users.get(t).notebook.add("I refuted the hypothesis by showing card "+game.allCard.get(cardIndex[i]).getName()+"\n");
			         game.users.get(t).notebook.add("************************************************************");
			            player.notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing the card "+game.allCard.get(cardIndex[i]).getName()+"\n");
			            player.notebook.add("************************************************************");
			            JOptionPane.showMessageDialog(null, game.users.get(t).getName()+" refuted the hypothesis by showing the card "+game.allCard.get(cardIndex[i]).getName(), "", JOptionPane.INFORMATION_MESSAGE); 
			            for(int j=0;j<game.users.size();j++){
	    		             if(j!=x && j!=t){
	    			            game.users.get(j).notebook.add(player.getName()+" made the hypothesis that "+keyword.get(0)+" made the murder in the "+keyword.get(2)+" with the "+keyword.get(1)+"\n");
	    			            game.users.get(j).notebook.add(game.users.get(t).getName()+" refuted the hypothesis by showing a card\n");
	    		                game.users.get(j).notebook.add("************************************************************");
	    		}
	    	}
	    	              found=true;
	    	              break outerloop;
	    }
		    	
	    	}  	}
	   
	    	}
	    //move the pawns into the room
	    game.charPawn.get(suspect).setPosition(player.character.getPosition());
	    game.weaponPawn.get(weaponIndex).setPosition(player.character.getPosition());
	    keyword.remove(person);
	    keyword.remove(weapon);
	    keyword.remove(room);
	    
	    if(found==false){
	    	player.notebook.add("Nothing has been found !");
	    	JOptionPane.showMessageDialog(null, "Nothing has been found", "", JOptionPane.INFORMATION_MESSAGE);
	    }
	       player.raise=true;
	    	}
	    	  
	

	public void movePawn( Pawn pawn, int newPosition) {
		pawn.setPosition(newPosition);
	}
	//@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b0){
           person=(String) c0.getSelectedItem();
           weapon=(String) c1.getSelectedItem();
           
           keyword.add(person);
      	   keyword.add(weapon);
      	   keyword.add(room);
      	   hy.setVisible(false);
      	   processHypothesis();
           }
        }
		
	}
	
	



