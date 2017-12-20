package ie.ucd.cluedo;

/**
 * This class represents a Weapon Pawn
 * It is moved from room to room using the hypothesis class
 */

public class WeaponPawn extends Pawn{
	
	public WeaponPawn(String name,int position){
		super();
		String type = "Weapon";
		this.name=name;
		this.position=position;
	}
}
