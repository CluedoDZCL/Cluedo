package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This class represents the game functionality
 * It creates the different pawns, cards and players
 * It creates the mystery and distributes the cards
 */

public class Game {
	protected   List<Card> charCards;
	protected   List<Card> weaponCards;
	protected List<Card> roomCards;
	protected List<Card> mystery;
	protected List<Card> combinedCards;
	protected  List<Player> users;
	protected   List<Pawn> charPawn;
	protected   List<Pawn> weaponPawn;
	protected List<Pawn> pawns;
	protected List<Pawn> pawnList;
	protected List<Pawn> userChar;
	protected List<Card> allCard;
	protected List<Pawn> charCreate;
	int number;
	boolean solved;
	boolean wait;
		
	public Game() {
		charCards = new ArrayList<Card>();		
		weaponCards = new ArrayList<Card>();	
		roomCards = new ArrayList<Card>();
		mystery = new ArrayList<Card>();
		combinedCards = new ArrayList<Card>();
		users=new ArrayList<Player>();
		charPawn = new ArrayList<Pawn>();
		weaponPawn = new ArrayList<Pawn>();
		pawns = new ArrayList<Pawn>();
		pawnList = new ArrayList<Pawn>();
		userChar=new ArrayList<Pawn>();
		allCard=new ArrayList<Card>();
		charCreate=new ArrayList<Pawn>();
		solved=false;
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
		
		allCard.addAll(charCards);
		allCard.addAll(roomCards);
		allCard.addAll(weaponCards);
	}
	
	
	
	public void createPawns(){
		//create weapon pawns
		Pawn candlestick_Pawn = new WeaponPawn("candlestick", 0);
		Pawn knife_Pawn = new WeaponPawn("knife", 12);
		Pawn pipe_Pawn = new WeaponPawn("lead pipe", 24);
		Pawn revolver_Pawn = new  WeaponPawn("revolver",30);
		Pawn rope_Pawn = new WeaponPawn("rope",36);
		Pawn poison_Pawn = new WeaponPawn("poison",48);
		weaponPawn.add(candlestick_Pawn);
		weaponPawn.add(knife_Pawn);
		weaponPawn.add(pipe_Pawn);
		weaponPawn.add(revolver_Pawn);
		weaponPawn.add(rope_Pawn);
		weaponPawn.add(poison_Pawn);
		
		//create character pawns
		Pawn scarlett_Pawn = new CharPawn("Miss Scarlett",3);
		Pawn plum_Pawn = new CharPawn("Professor Plum",15);
		Pawn peacock_Pawn = new CharPawn("Mrs. Peacock",27);
		Pawn green_Pawn = new CharPawn("Reverend Green",33);
		Pawn mustard_Pawn = new CharPawn("Colonel Mustard",45);
		Pawn white_Pawn = new CharPawn("Mrs White",51);
		charPawn.add(scarlett_Pawn);
		charPawn.add(plum_Pawn);
		charPawn.add(peacock_Pawn);
		charPawn.add(green_Pawn);
		charPawn.add(mustard_Pawn);
		charPawn.add(white_Pawn);
		
		//charCreate list is especially used in showing the available character for the players to chose
		charCreate.add(scarlett_Pawn);
		charCreate.add(plum_Pawn);
		charCreate.add(peacock_Pawn);
		charCreate.add(green_Pawn);
		charCreate.add(mustard_Pawn);
		charCreate.add(white_Pawn);
		
		for (int i=0; i<weaponPawn.size(); i++) {
			pawns.add(weaponPawn.get(i));
			pawns.add(charPawn.get(i));
		}
	}
	

	public void creatPlayer(){
		while(true) {
			//if the number is suitable, then go to the next stage
			number=scanNumberPlayers();
			if(!(number==-1)) break;
		}	    
		for(int i=0;i<number;i++){
			//returns player name, ensures no duplicate names
			Player player = new Player(scanPlayerName(i));
			users.add(player);
			//let the player choose their character pawn
			selectCharacter(player);
		}
	}
	
	
	public int scanNumberPlayers() {
		//the while loop is used for making sure the input index is between 3 and 6
		//if the user input another number it will go back to the loop and demand another input
		int amount;
		System.out.println("How many players do you have(should between 3 and 6)");
		Scanner in=new Scanner(System.in);
		String inputstr=in.nextLine();
			try	{
				amount=Integer.parseInt(inputstr);//process the integer input
				if(amount>=3 && amount<=6){
					return amount;
				}else {
					System.out.println("please input a number between 3 and 6");
					return -1;
				}
			}
			catch(NumberFormatException nfe) {
				//demanding another input if the current input is character
				System.out.println("please input a number between 3 and 6");
				return -1;
			}
	}
	
	public String scanPlayerName(int i) {
		String playerName=null;
		System.out.print("welcome player No."+(i+1)+ ", what is your name?\n");
	    while(true) {
	    	Scanner scc=new Scanner(System.in);
			playerName=scc.nextLine();
			//check if the name has been used, if it is then go back to the loop to demand another input
			if(!checkDuplicate(playerName)) {
				break;
				}
			}
	    return playerName;
	}
	
	public boolean checkDuplicate(String playerName) {
		boolean duplicate=false;
		for(int j=0;j<users.size();j++){
			if(users.get(j).getName().equals(playerName)){
				System.out.println("Duplicate user name, please input another name");
				duplicate=true;
			}
		}
		return duplicate;
	}
	
	 public void selectCharacter(Player A){
		 int index;
		 //print all the available characters
		 for(int t=0;t<charCreate.size();t++){  
			 System.out.println((t+1)+") "+charCreate.get(t).getName());  
		  } 
		 while(true){
			 index=scanCharicter();
			 if(!(index==-1)){
				 A.character=charCreate.get(index-1);
				 charCreate.remove(index-1);//the current character is not available any more,so delete it from the list
				 break; //break the while(true) loop
				}
			 else  System.out.println("please input the index number");
			}
		 }
	 
	 public int scanCharicter() {
		 int index;
		 System.out.println("what character you want to be, please input the index");
		 Scanner sc=new Scanner(System.in);
		 String inputIndex=sc.nextLine();
		   try{
			   index=Integer.parseInt(inputIndex);
			   if (index>=1 && index<=charCreate.size()) {
				  return index; 
			   }
			   else return -1;
			}
		   catch(NumberFormatException nfe) {
			  return -1;
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
	
	public boolean checkMystery(String charicter, String room, String weapon) {
		if (mystery.get(0).getName().equals(charicter) && mystery.get(1).getName().equals(room) && 
				mystery.get(2).getName().equals(weapon)) {
			solved=true;
			return true;
		}
		else {
			return false;
		}
	
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
		int iteration = combinedCards.size();
		for (int i = 0; i<iteration; i+=1) {
			//cycle through player arrays and add random card
			Random rand = new Random();
			int randIndex = rand.nextInt(combinedCards.size());
			users.get(i % number).getPlayerCards().add(combinedCards.get(randIndex));
			combinedCards.remove(randIndex);
		}
	}
	
	public List<Card> getCards(int index){
		return users.get(index).getPlayerCards(); //return all the cards of a player
	}
	
	
	public int findHolder(Card card) { //find out the card holder
		int index = 0;
		for (int i=0; i< users.size();i+=1) {
			if (users.get(i).contains(card)){
				index=i;	//return the index of the player				
			} 
		}
		return index;
	}
	public int findCard(String name){ //find out the card index
		int index=0;
		 for(int t=0;t<allCard.size();t++){
			 if(allCard.get(t).getName().equals(name)){
				 index=t;
				}
		 }
		return index;
	}
	
	
	public void mysterySolved() {
		solved=true;
	}
	
	
	public void startGame(Hypothesis hepo, Board board){
		int currentPlayer=-1;
		//initial notebook
		for(int t=0;t<number;t++){
			users.get(t).initializeNotebook();
		}
		//keep loop for every round until the game is solved
		while (!solved) {
			currentPlayer++;
			if (users.get(currentPlayer%number).playing) {
				System.out.println("\n--------------------------------------------------------------------------- \n");
				System.out.println("Its " + users.get(currentPlayer%number).getName() + "'s turn");
	            System.out.println("your current position is "+users.get(currentPlayer%number).getCharacter().getPosition());
	            users.get(currentPlayer% number).checkCard();
	            users.get(currentPlayer % number).checkNotebook();
				users.get(currentPlayer % number).movement();
			    users.get(currentPlayer % number).choice(this, hepo, board);
				}
			}
		}
	}
	

