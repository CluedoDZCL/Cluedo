package ie.ucd.cluedo;

public abstract class Card{

	public String name;
	public String type;
		
	public String getName(){
		return name;		
	}
	
	public String getType() {
		return type;
	}
	/*
	public int getCard(Card card) {
		for (int i=0; i< user.size();i+=1) {
			if (user.get(j).contains(card)){
				return j;
			}
		}
		
	}
	*/

}