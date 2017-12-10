package ie.ucd.cluedo;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map extends WindowAdapter implements ActionListener{
	JFrame fCon;
	JFrame fPic;
    JPanel p1,p2,p3;
    JLabel l;
	JLabel l1;
    JButton b,b1;
    ImageIcon icon;
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
		fCon=new JFrame("Check the Map");
		fPic=new JFrame("Appartment");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		b=new JButton("check");
		b1=new JButton("close");
		b.addActionListener(this);
		b1.addActionListener(this);
		l=new JLabel("Click here to check the map");
		ImageIcon icon=new ImageIcon("C:/MyProject/Cluedo/src/ie/ucd/cluedo/apartment.png");
		l1=new JLabel(icon, JLabel.CENTER);
	}
	public void checkMap(){
		
		 p2.setLayout(new BorderLayout());
         p2.add("West", l);
	     p2.add("East", b);
	         
	     p1.setLayout(new GridLayout(1, 1));
	     p1.add(p2);
	     fCon.add(p1);
	     fCon.addWindowListener(new Map());
	     fCon.setSize(1000,1000);
	     fCon.setVisible(true);
	     fCon.pack();
	     
	     p3.add(l1);
	     p3.add(b1);
	     fPic.add(p3);
	     fPic.addWindowListener(new Map());
	     fPic.setSize(1000, 1000);
	     fPic.setVisible(false);
	     fPic.pack();
	     
		
	}

}
