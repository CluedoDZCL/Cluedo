package ie.ucd.cluedo;

public class WeaponPawn extends Pawn{
	String name;
	public WeaponPawn(String name,int position){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public void move(int newPosition) {
		position=newPosition;
	}

	public int checkPosition() {
		return position;
	}
}
