package ie.ucd.cluedo;

import java.awt.BorderLayout;


import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the map display
 * It creates a Jframe for the map to be viewed
 */

public class Map implements ActionListener{
	JFrame fCon;
	JFrame fPic;
    JPanel p1,p2,p3;
    JLabel l;
	JLabel l1;
    JButton b,b1;
    ImageIcon  i;
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == b){
			 fCon.setVisible(false); 
			 fPic.setVisible(true);
	        }// TODO Auto-generated method stub
		 if(e.getSource() == b1){
			 fCon.setVisible(true); 
			 fPic.setVisible(false);
		 }
	}
	public Map(){
		fCon=new JFrame("View the Map");
		fPic=new JFrame("Appartment");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		b=new JButton("check");
		b1=new JButton("close");
		b.addActionListener(this);
		b1.addActionListener(this);
		l=new JLabel("Click here to view the map");
		i=new  ImageIcon(getClass().getResource("apartment.png"));
		l1=new JLabel(i, JLabel.CENTER);
	}
	public void checkMap(){
		 p2.setLayout(new BorderLayout());
         p2.add("West", l);
	     p2.add("East", b);
	         
	     p1.setLayout(new GridLayout(1, 1));
	     p1.add(p2);
	     fCon.add(p1);
	     fCon.setSize(1000,1000);
	     fCon.setVisible(true);
	     fCon.pack();
	     
	     p3.add(l1);
	     p3.add(b1);
	     fPic.add(p3);
	     fPic.setSize(1000, 1000);
	     fPic.setVisible(false);
	     fPic.pack();
	  }
}
	
