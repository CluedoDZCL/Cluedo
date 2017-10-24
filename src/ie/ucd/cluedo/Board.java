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
		
		Pawn candlestick_pawn = new WeaponPawn("candlestick_pawn", 1);
		Pawn knife_pawn = new WeaponPawn("knife_pawn", 2);
		Pawn pipe_pawn = new WeaponPawn("lead pipe_pawn", 3);
		Pawn revolver_pawn = new  WeaponPawn("revolver_pawn",4);
		Pawn rope_pawn = new WeaponPawn("rope_pawn",5);
		Pawn poison_pawn = new WeaponPawn("poison_pawn",6);
		
		Pawn scarlett_Pawn = new CharPawn("Miss Scarlett_Pawn",1);
		Pawn plum_Pawn = new CharPawn("Professor Plum_Pawn",2);
		Pawn peacock_Pawn = new CharPawn("Mrs. Peacock_Pawn",3);
		Pawn green_Pawn = new CharPawn("Reverend Green_Pawn",4);
		Pawn mustard_Pawn = new CharPawn("Colonel Mustard_Pawn",5);
		Pawn white_Pawn = new CharPawn("Mrs White_Pawn",6);
	}
	
	

	public void Mystery(){
		//remove card each array
		
		//add each card mystery array
		
	}
}
