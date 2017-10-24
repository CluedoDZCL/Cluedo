package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	protected List<Card> charCards;
	protected List<Card> weaponCards;
	protected List<Card> roomCards;
		
	public Board() {
		charCards = new ArrayList<Card>();		
		weaponCards = new ArrayList<Card>();	
		roomCards = new ArrayList<Card>();	
	}

}
