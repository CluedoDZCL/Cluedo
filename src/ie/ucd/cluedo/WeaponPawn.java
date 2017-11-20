package ie.ucd.cluedo;

public class WeaponPawn extends Pawn{
	String name;
	public WeaponPawn(String name,int position){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public int checkPosition() {
		return position;
	}
	
	public void setPosition(int pos) {
		position=pos;
	}
}
