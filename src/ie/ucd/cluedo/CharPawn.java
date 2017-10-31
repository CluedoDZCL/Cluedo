package ie.ucd.cluedo;
import java.util.Random;
import javax.swing.JOptionPane;

public class CharPawn extends Pawn{
	
	public CharPawn(String name, int position) {
		String type = "Charicter";
	}
	public void Move(CharPawn A){
		Random rand = new Random();
		int diceroll = rand.nextInt(6)+1;
	//	if(A.getPosition+diceroll>)
		JOptionPane.showConfirmDialog(null, "Do u want to take"+diceroll+"step?", "", JOptionPane.YES_NO_OPTION); 
	}

}
