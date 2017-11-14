package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {
	protected static List<Card> charCards;
	protected static List<Card> weaponCards;
	protected List<Card> roomCards;
	protected List<Card> mystery;
	protected List<Card> combinedCards;
	protected static List<Player> users;
	protected List<Pawn> charapawn;
	int number;
		
	public Game() {
		charCards = new ArrayList<Card>();		
		weaponCards = new ArrayList<Card>();	
		roomCards = new ArrayList<Card>();
		mystery = new ArrayList<Card>();
		combinedCards = new ArrayList<Card>();
		users=new ArrayList<Player>();
		charapawn = new ArrayList<Pawn>();
	}
	
	public void createCards() {
		//create character cards
		Card scarlett = new CharCard("Miss Scarlett");
		Card plum = new CharCard("Professor Plum");
		Card peacock = new CharCard("Mrs. Peacock");
		Card green = new CharCard("Reverend Green");
		Card mustard = new CharCard("Colonel Mustard");
		Card white = new CharCard("Mrs White");
		charCards.add(scarlett);
		charCards.add(plum);
		charCards.add(peacock);
		charCards.add(green);
		charCards.add(mustard);		
		charCards.add(white);
		
		//create room cards
		Card kitchen = new RoomCard("Kitchen");
		Card ballroom = new RoomCard("Ballroom");
		Card conservatory = new RoomCard("Conservatory");
		Card dining = new RoomCard("Dining Room");
		Card lounge = new RoomCard("Lounge");
		Card hall = new RoomCard("Hall");
		Card study = new RoomCard("Study");
		Card billiard = new RoomCard("Billiard Room");
		Card library = new RoomCard("Library");
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
		Card candlestick = new WeaponCard("candlestick");
		Card knife = new WeaponCard("knife");
		Card pipe = new WeaponCard("lead pipe");
		Card revolver = new  WeaponCard("revolver");
		Card rope = new WeaponCard("rope");
		Card poison = new WeaponCard("poison");
		weaponCards.add(candlestick);
		weaponCards.add(knife);
		weaponCards.add(pipe);
		weaponCards.add(revolver);
		weaponCards.add(rope);		
		weaponCards.add(poison); 
	}
	
	
	
	public void createPawns(){
		Pawn candlestick_pawn = new WeaponPawn("candlestick_pawn", 0);
		Pawn knife_pawn = new WeaponPawn("knife_pawn", 10);
		Pawn pipe_pawn = new WeaponPawn("lead pipe_pawn", 20);
		Pawn revolver_pawn = new  WeaponPawn("revolver_pawn",30);
		Pawn rope_pawn = new WeaponPawn("rope_pawn",40);
		Pawn poison_pawn = new WeaponPawn("poison_pawn",50);
		
		Pawn scarlett_Pawn = new CharPawn("Miss Scarlett_Pawn",15);
		Pawn plum_Pawn = new CharPawn("Professor Plum_Pawn",25);
		Pawn peacock_Pawn = new CharPawn("Mrs. Peacock_Pawn",35);
		Pawn green_Pawn = new CharPawn("Reverend Green_Pawn",45);
		Pawn mustard_Pawn = new CharPawn("Colonel Mustard_Pawn",55);
		Pawn white_Pawn = new CharPawn("Mrs White_Pawn",65);
		charapawn.add(scarlett_Pawn);
		charapawn.add(plum_Pawn);
		charapawn.add(peacock_Pawn);
		charapawn.add(green_Pawn);
		charapawn.add(mustard_Pawn);
		charapawn.add(white_Pawn);
	}
	

	public void creatPlayer(){
	 System.out.println("How many players do you have(should between 3 and 6)");
	 Scanner in=new Scanner(System.in);
	 number=in.nextInt();
	 Random rand = new Random();
	 int randomPawn = rand.nextInt(6);
	 for(int i=0;i<number;i++){
		 System.out.print("what is your name?");
		 Scanner scc=new Scanner(System.in);
		 String playerName=scc.nextLine();
		 Player A=new Player(playerName);
		 System.out.println("what character you want to be");
		 Scanner sc=new Scanner(System.in);
		 String name=sc.nextLine();
		 for(int j=0;j<charapawn.size();j++){ 
		if(users.get(j).character.getName().equals(name)){
		 A.character=charapawn.get(j);
		 break;
		 }}
		 users.add(A);
		 }
	}

	
	public void createMystery(){
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
		//Add all cards to one array
		for (int j=0; j<charCards.size(); j+=1) {
			combinedCards.add(charCards.get(j));
			combinedCards.add(weaponCards.get(j));
		}
		for (int j=0; j<roomCards.size(); j+=1) {
			combinedCards.add(roomCards.get(j));
		}		
		for (int i = 0; i<combinedCards.size(); i+=1) {
			//cycle through player arrays and add random card
			Random rand = new Random();
			int randIndex = rand.nextInt(combinedCards.size());
			users.get(i % number).getPlayerCards().add(combinedCards.get(randIndex));
		}
	}
	
	public List<Card> getCards(int index){
		return users.get(index).getPlayerCards();
	}
	
	
	public int getCard(Card card) {
		int index = 0;
		for (int i=0; i< users.size();i+=1) {
			if (users.get(i).contains(card)){
				index=i;	//return the index of the player				
			} 
		}
		return index;
	}
	public static int findcharCard(String name){
		int index=0;
		for(int i=0;i<charCards.size();i++){
			if(charCards.get(i).getName().equals(name))
				index=i;
		}
		return index;
	}
	public static int findweaponCard(String name){
		int index=0;
		for(int i=0;i<weaponCards.size();i++){
			if(weaponCards.get(i).getName().equals(name))
				index=i;
		}
		return index;
	}
	//public int findroomCard(String )
		
}
	

