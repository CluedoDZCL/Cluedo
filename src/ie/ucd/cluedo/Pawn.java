package ie.ucd.cluedo;

/**
 * This class represents a generic Pawn
 */

public abstract class Pawn{
	public int position;
	public String name;
	public String type;
		
	public int getPosition() {
		return position;
	}
	
	/**
	 * This method controls the pawns position
	 * Ensures pawn cant go outside board boundry
	 * works for negative numbers 
	 */
	public void setPosition(int pos) {
		position=(pos+54) % 54; 
	}
	
	public String getName(){
		return name;		
	}
	
	public String getType() {
		return type;
	}
	

}
