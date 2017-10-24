package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		//create character cards
		CharCard scarlett = new CharCard("Miss Scarlett");
		scarlett.add(scarlett);
		CharCard plum = new CharCard("Professor Plum");
		plum.add(plum);
		CharCard peacock = new CharCard("Mrs. Peacock");
		peacock.add(peacock);
		CharCard green = new CharCard("Reverend Green");
		green.add(green);
		CharCard mustard = new CharCard("Colonel Mustard");
		mustard.add(mustard);
		CharCard white = new CharCard("Mrs White");
		white.add(white);
		
		//create room cards
		RoomCard kitchen = new RoomCard("Kitchen");
		kitchen.add(kitchen);
		RoomCard ballroom = new RoomCard("Ballroom");
		ballroom.add(ballroom);
		RoomCard conservatory = new RoomCard("Conservatory");
		conservatory.add(conservatory);
		RoomCard dining = new RoomCard("Dining Room");
		dining.add(dining);
		RoomCard lounge = new RoomCard("Lounge");
		lounge.add(lounge);
		RoomCard hall = new RoomCard("Hall");
		hall.add(hall);
		RoomCard study = new RoomCard("Study");
		study.add(study);
		RoomCard billiard = new RoomCard("Billiard Room");
		billiard.add(billiard);
		RoomCard library = new RoomCard("Library");
		library.add(library);
		
		//create weapon cards
		WeaponCard candlestick = new WeaponCard("candlestick");
		candlestick.add(candlestick);
		WeaponCard knife = new WeaponCard("knife");
		knife.add(knife);
		WeaponCard pipe = new WeaponCard("lead pipe");
		pipe.add(pipe);
		WeaponCard revolver = new  WeaponCard("revolver");
		revolver.add(revolver);
		WeaponCard rope = new WeaponCard("rope");
		rope.add(rope);
		WeaponCard poison = new WeaponCard("poison");
		poison.add(poison);
	}
	
	

	public void Mystery(){
		//remove card each array
		int randomChar = randomGenerator.nextInt(7);
		int randomRoom = randomGenerator.nextInt(10);
		int randomWeapon = randomGenerator.nextInt(7);
		
		
		//add each card mystery array
		
	}
}
