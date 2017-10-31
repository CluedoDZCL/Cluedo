package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Game {
	protected List<Card> charCards;
	protected List<Card> weaponCards;
	protected List<Card> roomCards;
	protected List<Card> mystery;
	protected List<Player> Users;
		
	public Game() {
		charCards = new ArrayList<Card>();		
		weaponCards = new ArrayList<Card>();	
		roomCards = new ArrayList<Card>();
		mystery = new ArrayList<Card>();
		Users=new ArrayList<Player>();
	}
	
	public List<Card> getCharCards(){
		return charCards;
	}
	
	public void createCards() {
		//create character cards
		CharCard scarlett = new CharCard("Miss Scarlett");
		CharCard plum = new CharCard("Professor Plum");
		CharCard peacock = new CharCard("Mrs. Peacock");
		CharCard green = new CharCard("Reverend Green");
		CharCard mustard = new CharCard("Colonel Mustard");
		CharCard white = new CharCard("Mrs White");
		charCards.add(scarlett);
		charCards.add(plum);
		charCards.add(peacock);
		charCards.add(green);
		charCards.add(mustard);		
		charCards.add(white);
		
		//create room cards
		RoomCard kitchen = new RoomCard("Kitchen");
		RoomCard ballroom = new RoomCard("Ballroom");
		RoomCard conservatory = new RoomCard("Conservatory");
		RoomCard dining = new RoomCard("Dining Room");
		RoomCard lounge = new RoomCard("Lounge");
		RoomCard hall = new RoomCard("Hall");
		RoomCard study = new RoomCard("Study");
		RoomCard billiard = new RoomCard("Billiard Room");
		RoomCard library = new RoomCard("Library");
		roomCards.add(kitchen);
		roomCards.add(ballroom);
		roomCards.add(conservatory);
		roomCards.add(dining);
		roomCards.add(lounge);
		roomCards.add(hall);
		roomCards.add(study);
		roomCards.add(billiard);		
		roomCards.add(library);
		
		//create weapon cards
		WeaponCard candlestick = new WeaponCard("candlestick");
		WeaponCard knife = new WeaponCard("knife");
		WeaponCard pipe = new WeaponCard("lead pipe");
		WeaponCard revolver = new  WeaponCard("revolver");
		WeaponCard rope = new WeaponCard("rope");
		WeaponCard poison = new WeaponCard("poison");
		weaponCards.add(candlestick);
		weaponCards.add(knife);
		weaponCards.add(pipe);
		weaponCards.add(revolver);
		weaponCards.add(rope);		
		weaponCards.add(poison); 
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
	 System.out.println("How many players do you have(should between 3 and 6)");
	 Scanner in=new Scanner(System.in);
	 int number=in.nextInt();
	 for(int i=0;i<number;i++){
		 Player A=new Player();
		 Users.add(A);
	 }
	
	
	}
	
	
	public void Mystery(){
	public void creatPlayer(){
		System.out.println("How many of players do you have?");
		Scanner in=new Scanner(System.in);
		int number=in.nextInt();
		for (int i=0;i<number;i++){
			Player A = new Player();
			users.add(A);//so that the players can be called by users[i];
		}
		//assign the card to each person
	}
	
	public void mystery(){
>>>>>>> 76723a53eebfb86cc9cd9038213ebab867c4d390
		//randomly select card
		Random rand = new Random();		
		int randomChar = rand.nextInt(6);
		int randomRoom = rand.nextInt(9);
		int randomWeapon = rand.nextInt(6);		
		
		//add each card mystery array
		mystery.add(charCards.get(randomChar));
		mystery.add(roomCards.get(randomRoom));
		mystery.add(weaponCards.get(randomWeapon));
		
		//remove card each array
		charCards.remove(randomChar);
		roomCards.remove(randomRoom);
		weaponCards.remove(randomWeapon);
	}
	
	public void distributeCards() {
		for (int i = 0; i<19; i+=1) {
			//cycle through player arrays and add
			if (i<6) {
				
			}else if (i<11) {
				
			}else if (i<19) {
				
			}else {
				System.out.println("Error card distribution");
			}
		}
	}
	
	
}
