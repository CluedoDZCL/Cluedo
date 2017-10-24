package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
	
	public void createPawns(){
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
	public void Creatplayer(){
		System.out.println("How many of players do you have?");
		Scanner in=new Scanner(System.in);
		int number=in.nextInt();
		for (int i=0;i<number;i++){
			Player A=new Player();
		}
		//assign the card to each person
	}
	
	

	public void Mystery(){
		//remove card each array
		Random rand = new Random();		
		int randomChar = rand.nextInt(7);
		int randomRoom = rand.nextInt(10);
		int randomWeapon = rand.nextInt(7);		
		
		//add each card mystery array
		mystery.add(charCards.get(randomChar));
		mystery.add(roomCards.get(randomRoom));
		mystery.add(weaponCards.get(randomWeapon));
		
		charCards.remove(randomChar);
		roomCards.remove(randomRoom);
		weaponCards.remove(randomWeapon);
		
	}
}
