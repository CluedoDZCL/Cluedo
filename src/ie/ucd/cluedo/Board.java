package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	protected List<Card> charCards;
	protected List<Card> weaponCards;
	protected List<Card> roomCards;
	protected List<Card> mystery;
		
	public Board() {
		charCards = new ArrayList<Card>();		
		weaponCards = new ArrayList<Card>();	
		roomCards = new ArrayList<Card>();
		mystery = new ArrayList<Card>();
	}
	
	public void CreateCards() {
		CharCard scarlett = new CharCard("Miss Scarlett");
		CharCard plum = new CharCard("Professor Plum");
		CharCard peacock = new CharCard("Mrs. Peacock");
		CharCard green = new CharCard("Reverend Green");
		CharCard mustard = new CharCard("Colonel Mustard");
		CharCard white = new CharCard("Mrs White");
		
		RoomCard kitchen = new RoomCard("Kitchen");
		RoomCard ballroom = new RoomCard("Ballroom");
		RoomCard conservatory = new RoomCard("Conservatory");
		RoomCard dining = new RoomCard("Dining Room");
		RoomCard lounge = new RoomCard("Lounge");
		RoomCard hall = new RoomCard("Hall");
		RoomCard study = new RoomCard("Study");
		RoomCard billiard = new RoomCard("Billiard Room");
		RoomCard library = new RoomCard("Library");
		
		WeaponCard candlestick = new WeaponCard("candlestick");
		WeaponCard knife = new WeaponCard("knife");
		WeaponCard pipe = new WeaponCard("lead pipe");
		WeaponCard revolver = new  WeaponCard("revolver");
		WeaponCard rope = new WeaponCard("rope");
		WeaponCard poison = new WeaponCard("poison");
	}
	
	

	public void Mystery(){
		//remove card each array
		
		//add each card mystery array
		
	}
}
