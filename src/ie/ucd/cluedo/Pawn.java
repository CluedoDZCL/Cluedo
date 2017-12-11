package ie.ucd.cluedo;

public abstract class Pawn{
	public int position;
	public String name;
	public String type;
		
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int pos) {
		position=(pos+54) % 54; //works for negative numbers
	}
	
	public String getName(){
		return name;		
	}
	
	public String getType() {
		return type;
	}
	

}
