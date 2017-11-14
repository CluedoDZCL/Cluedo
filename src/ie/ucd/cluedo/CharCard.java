package ie.ucd.cluedo;

public class CharCard extends Card {
	String name;
	public CharCard(String name) {
		String type = "Charicter";
		//add to array
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
}
