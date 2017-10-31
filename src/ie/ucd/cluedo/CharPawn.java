package ie.ucd.cluedo;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CharPawn extends Pawn{
	int position;
	
	public CharPawn(String name, int position) {
		String type = "Charicter";
		this.position=position;
	}
	public void move(){
		Random rand = new Random();
		int diceroll = rand.nextInt(6)+1;
		int res;
	    res=JOptionPane.showConfirmDialog(null,"Are you sure you want to go"+diceroll+"steps?",
	     "",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		if(res==JOptionPane.YES_OPTION){
			position=diceroll+position;
			}
		if(res==JOptionPane.NO_OPTION){
			System.out.println("How many steps do you want to go?");
			Scanner in=new Scanner(System.in);
			int number=in.nextInt();
			position=position+number;
		}
	}
	public int getPosition(){
		return position;
	}
	

}
