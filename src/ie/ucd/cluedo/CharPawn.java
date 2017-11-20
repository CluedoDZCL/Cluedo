package ie.ucd.cluedo;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CharPawn extends Pawn{
	int position;
	String name;
	
	public CharPawn(String name, int position) {
		String type = "Charicter";
		this.position=position;
		this.name=name;
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setPosition(int pos) {
		position=pos;
	}
	
	public String getName(){
		return name;
	}
	
}
