package ie.ucd.cluedo;

/**
 * This class represents a Character Pawn
 * It can be moved by the player that chooses it
 */

public class CharPawn extends Pawn{
	
	public CharPawn(String name, int position) {
		super();
		String type = "Character";
		this.position=position;
		this.name=name;
	}
}
