package ie.ucd.cluedo;

/**
 * This class represents a generic Room on the board
 */

public class Room {
	protected int position;
	protected String name;
	
	public Room(int position, String name) {
		this.name=name;
		this.position=position;
	}
	
	public int getPosition() {
		return position;
	}
	public String getName(){
		return name;
	}
	
}
