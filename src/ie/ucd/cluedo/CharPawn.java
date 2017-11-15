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
	public String getName(){
		return name;
	}
	
	public int checkPosition() {
		return position;
	}

}
