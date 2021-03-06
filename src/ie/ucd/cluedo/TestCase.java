package ie.ucd.cluedo;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCase {
	CharPawn charPawn = null;
	WeaponPawn weaponPawn=null;
	CharCard charCard=null;
	WeaponCard weaponCard=null;
	RoomCard roomCard=null;
	Room room=null;
	Board board=null;
	Game cluedo=null;
	Player player=null;
	Player player2=null;
	Player player3=null;
	Hypothesis hypo=new Hypothesis();
	Map map=null;
	ByteArrayInputStream in=null;
	

	@BeforeClass
	public static void BeforeClass(){	
		 	//initialise variables
		 	System.out.println("BeforeClass");	
	}	
	
	@Before	
	public void setUp() throws Exception{	
		charPawn = new CharPawn("Charicter", 15);
		weaponPawn = new WeaponPawn("Weapon",18);
		charCard= new CharCard("Charicter");
		weaponCard= new WeaponCard("Weapon");
		roomCard=new RoomCard("Study");
		room= new Room(20,"Room");
		board= new Board();
		cluedo= new Game();
		player= new Player("Player");
		board.rooms.add(room);
		cluedo.pawns.add(charPawn);
		cluedo.users.add(player);
		
		System.out.println("setUp");	
	}
	
	@Test	
	public void testCharPawn(){
		Assert.assertEquals("Test position Constructor", 15, charPawn.getPosition(),	0);	
		charPawn.setPosition(30);
		Assert.assertEquals("Test position setter", 30,	charPawn.getPosition(),	0);	
		charPawn.setPosition(60);
		Assert.assertEquals("Test modulus position", 6,	charPawn.getPosition(),	0);
		charPawn.setPosition(-10);
		Assert.assertEquals("Test modulus position", 44, charPawn.getPosition(),	0);
	}
	
	@Test	
	public void testWeaponPawn(){
		Assert.assertEquals("Test position Constructor", 18, weaponPawn.getPosition(),	0);	
		weaponPawn.setPosition(30);
		Assert.assertEquals("Test position setter", 30,	weaponPawn.getPosition(),	0);	
		weaponPawn.setPosition(60);
		Assert.assertEquals("Test positive modulus position", 6, weaponPawn.getPosition(),	0);
		weaponPawn.setPosition(-10);
		Assert.assertEquals("Test negitive modulus position", 44, weaponPawn.getPosition(),	0);
	}
	
	@Test	
	public void testCharCard(){
		Assert.assertEquals("Test name Constructor", "Charicter",charCard.getName());	
	}

	@Test	
	public void testWeaponCard(){
		Assert.assertEquals("Test name Constructor", "Weapon",weaponCard.getName());	
	}
	
	@Test	
	public void testRoom(){
		Assert.assertEquals("Test name Constructor", "Room",room.getName());	
		Assert.assertEquals("Test position Constructor", 20,room.getPosition());	
	}
	
	@Test	
	public void testBoard(){
		Assert.assertEquals("Test position Constructor",room.getName(),board.findRoom(20));
		Assert.assertEquals("Test position corridor","Corridor",board.findRoom(2));
		charPawn.setPosition(20);
		Assert.assertEquals("Test pawns in room",charPawn,board.checkRoom(cluedo,room).get(0));
		board.rooms.remove(room);
		board.createRooms();
		Assert.assertEquals("Test all rooms created",9,board.rooms.size());
	}
	
	@Test	
	public void testPlayer(){
		player2= new Player("Player2");
		cluedo.number=3;
		Pawn ssPawn = new CharPawn("Professor Plum", 15);
		Pawn green_Pawn = new CharPawn("Reverend Green",33);
		Pawn rrPawn = new WeaponPawn("poison",18);
		Room study = new Room(24,"Study");
		Card studyCard =new RoomCard("Study");
		board.rooms.add(study);
		
		//initial the conditions which are needed by accusation
		Card plum = new CharCard("Professor Plum");
		Card poison = new WeaponCard("poison");
		cluedo.users.add(player2);
		cluedo.charPawn.add(ssPawn);
		cluedo.weaponPawn.add(rrPawn);
		cluedo.charPawn.add(green_Pawn);
		player2.character=ssPawn;
		player2.character.setPosition(24);
		cluedo.createCards();
		
		cluedo.mystery.add(plum);
		cluedo.mystery.add(studyCard);
		cluedo.mystery.add(poison);
		
		player2.processAccusation(cluedo, board, 1, 1);
		Assert.assertEquals("Test the position of the suspect","Professor Plum",cluedo.charPawn.get(0).getName());
		Assert.assertEquals("Test the position of the weapon","poison",cluedo.weaponPawn.get(0).getName());
		Assert.assertEquals("Test the position of the suspect",24,cluedo.charPawn.get(0).getPosition());
		Assert.assertEquals("Test the position of the weapon",24,cluedo.weaponPawn.get(0).getPosition());
		
		player2.processAccusation(cluedo, board, 2, 1);
		Assert.assertEquals("Test the position of the suspect","Reverend Green",cluedo.charPawn.get(1).getName());
		Assert.assertEquals("Test the position of the weapon","poison",cluedo.weaponPawn.get(0).getName());
		Assert.assertEquals("Test the position of the suspect",24,cluedo.charPawn.get(1).getPosition());
		Assert.assertEquals("Test the position of the weapon",24,cluedo.weaponPawn.get(0).getPosition());
		
		
		cluedo.users.get(0).playerCards.add(charCard);
		Assert.assertTrue("Test check player has card",player.contains(charCard));
		
		System.setIn(new ByteArrayInputStream("3".getBytes()));
	    Assert.assertEquals("Test input suspect",3,player.scanSuspectAccusation());
		
	    System.setIn(new ByteArrayInputStream("8".getBytes()));
	    Assert.assertEquals("Test out of bounds input suspect",-1,player.scanSuspectAccusation());
	    
	    System.setIn(new ByteArrayInputStream("f".getBytes()));
	    Assert.assertEquals("Test invalid input suspect",-1,player.scanSuspectAccusation());
	    
	    System.setIn(new ByteArrayInputStream("6".getBytes()));
	    Assert.assertEquals("Test input suspect",6,player.scanWeaponAccusation());
		
	    System.setIn(new ByteArrayInputStream("9".getBytes()));
	    Assert.assertEquals("Test out bounds input suspect",-1,player.scanWeaponAccusation());
	    
	    System.setIn(new ByteArrayInputStream("a".getBytes()));
	    Assert.assertEquals("Test invalid input suspect",-1,player.scanWeaponAccusation());
	    
		player.initializeNotebook();
		
		System.setIn(new ByteArrayInputStream("2".getBytes()));
		Assert.assertEquals("Test valid movement amount",2,player.scanCheckCard());
		
		System.setIn(new ByteArrayInputStream("6".getBytes()));
		Assert.assertEquals("Test valid movement amount",-1,player.scanCheckCard());
		
		player.printNotebook();
		
		System.setIn(new ByteArrayInputStream("2".getBytes()));
		Assert.assertEquals("Test valid movement amount",2,player.scanCheckNotebook());
		
		System.setIn(new ByteArrayInputStream("2".getBytes()));
		Assert.assertEquals("Test valid movement amount",2,player.scanCheckNotebook());
		player.printCard();
		
		System.setIn(new ByteArrayInputStream("2".getBytes()));
		Assert.assertEquals("Test valid movement amount",2,player.steps(6));
				
		Assert.assertTrue("Test allowed movement amount",player.checkDiceroll(2,6));
		Assert.assertFalse("Test not allowed movement amount",player.checkDiceroll(8,6));
		
		System.setIn(new ByteArrayInputStream("2".getBytes()));
		Assert.assertEquals("Test valid movement choice",2,player.moveChoice());
		
		System.setIn(new ByteArrayInputStream("1".getBytes()));
		Assert.assertTrue("Test valid movement choice",player.scanShortcut());
		
		System.setIn(new ByteArrayInputStream("2".getBytes()));
		Assert.assertFalse("Test valid movement choice",player.scanShortcut());
		
		
	}
	@Test	
	public void testHypothesis(){
		//initial all the conditions which are needed by making a hypothesis
		CharPawn sPawn = new CharPawn("Miss Scarlett", 15);
		CharPawn green_Pawn = new CharPawn("Reverend Green",33);
		WeaponPawn rPawn = new WeaponPawn("rope",18);
		Room dining=new Room(0,"Dining Room");
		player3= new Player("Player3");
		cluedo.number=2;
		cluedo.users.add(player3);
		cluedo.charPawn.add(sPawn);
		cluedo.charPawn.add(green_Pawn);
		cluedo.weaponPawn.add(rPawn);
		board.rooms.add(dining);
		player3.character=sPawn;
		player3.character.setPosition(0);
		cluedo.createCards();
		
		//cards 'dining room', 'green','rope' are possessed by the player who raise hypothesis
		player3.playerCards.add(cluedo.allCard.get(3));
		player3.playerCards.add(cluedo.allCard.get(19));
		player3.playerCards.add(cluedo.allCard.get(9));
		
		//other players possess card 'scarlett'
		player.playerCards.add(roomCard);
		player.playerCards.add(cluedo.allCard.get(0));
		player.playerCards.add(weaponCard);
		
		//make hypothesis 1
		hypo.suspect=2;
		hypo.weaponIndex=1;
		hypo.found=false;
		
		hypo.initialElements(player3, cluedo, board, hypo.suspect, hypo.weaponIndex);
	    Assert.assertEquals("Test the amount of keyword",3,hypo.keyword.size());
	    Assert.assertEquals("Test the index of the person who raise hypothesis",1,hypo.x);
	    Assert.assertEquals("Test the length of cardIndex",3,hypo.cardIndex.length);
	    Assert.assertEquals("Test the name of the suspect","Reverend Green",hypo.keyword.get(0));
		
	    hypo.processHypothesis(player3, cluedo, board);
	    Assert.assertEquals("Test the statues of the founding",false,hypo.found);
		
	    hypo.endHypothesis(player3, cluedo, board);
		Assert.assertEquals("Test the amount of keyword",0,hypo.keyword.size());
		Assert.assertEquals("Test the position of the suspect",0,cluedo.charPawn.get(1).getPosition());
		Assert.assertEquals("Test the position of the weapon",0,cluedo.weaponPawn.get(0).getPosition());
		
		//make hypothesis 2
		hypo.suspect=1;
		hypo.weaponIndex=1;
		cluedo.weaponPawn.get(0).setPosition(25);//reset the position
		
		hypo.initialElements(player3, cluedo, board, hypo.suspect, hypo.weaponIndex);
	    Assert.assertEquals("Test the amount of keyword",3,hypo.keyword.size());
	    Assert.assertEquals("Test the index of the person who raise hypothesis",1,hypo.x);
	    Assert.assertEquals("Test the length of cardIndex",3,hypo.cardIndex.length);
	    Assert.assertEquals("Test the name of the suspect","Miss Scarlett",hypo.keyword.get(0));
		
	    hypo.processHypothesis(player3, cluedo, board);
	    Assert.assertEquals("Test the statues of the founding",true, hypo.found);
		
	    hypo.endHypothesis(player3, cluedo, board);
		Assert.assertEquals("Test the amount of keyword",0,hypo.keyword.size());
		Assert.assertEquals("Test the position of the suspect",0,cluedo.charPawn.get(0).getPosition());
		Assert.assertEquals("Test the position of the weapon",0,cluedo.weaponPawn.get(0).getPosition());
		
		System.setIn(new ByteArrayInputStream("3".getBytes()));
	    Assert.assertEquals("Test input suspect",3,hypo.scanSuspect());
		
	    System.setIn(new ByteArrayInputStream("8".getBytes()));
	    Assert.assertEquals("Test input suspect",-1,hypo.scanSuspect());
	    
	    System.setIn(new ByteArrayInputStream("6".getBytes()));
	    Assert.assertEquals("Test input suspect",6,hypo.scanWeapon());
		
	    System.setIn(new ByteArrayInputStream("9".getBytes()));
	    Assert.assertEquals("Test input suspect",-1,hypo.scanWeapon());
	    
	    
	}
	
	@Test	
	public void testGame(){
		cluedo.createCards();	
		cluedo.createMystery();	
		
		player2= new Player("Player2");
		cluedo.users.add(player2);
		cluedo.number=2;
		cluedo.createPawns();
		cluedo.distributeCards();
		
		Assert.assertEquals("Test amount cards",21,cluedo.allCard.size());
		Assert.assertEquals("Test amount mystery cards",3,cluedo.mystery.size());
		Assert.assertEquals("Test amount player cards",9,cluedo.users.get(0).playerCards.size());
		
		Assert.assertEquals("Test amount weapon pawns",6,cluedo.weaponPawn.size());
		Assert.assertEquals("Test amount weapon pawns",6,cluedo.charPawn.size());
		
		Assert.assertEquals("Test mystery 1 each type","Charicter",cluedo.mystery.get(0).getType());
		Assert.assertEquals("Test mystery 1 each type","Room",cluedo.mystery.get(1).getType());
		Assert.assertEquals("Test mystery 1 each type","Weapon",cluedo.mystery.get(2).getType());
	   	
		Assert.assertFalse("Test check mystery incorrect",cluedo.checkMystery("","",""));
		Assert.assertTrue("Test check mystery correct",cluedo.checkMystery(
		cluedo.mystery.get(0).getName(),cluedo.mystery.get(1).getName(),cluedo.mystery.get(2).getName()));
		
		Assert.assertEquals("Test finding owner of card",0,cluedo.findHolder(cluedo.getCards(0).get(0)));
		
		Assert.assertEquals("Test finding card in allCards",16,cluedo.findCard("knife"));
		
		cluedo.mysterySolved();
		Assert.assertTrue("Test solved setter",cluedo.solved);

	   System.setIn(new ByteArrayInputStream("1".getBytes()));
	   cluedo.selectCharacter(player);
	   Assert.assertEquals("Test allowed charicter selection","Miss Scarlett",player.character.getName());
	   
	   System.setIn(new ByteArrayInputStream("8".getBytes()));
	   Assert.assertEquals("Test incorrect charicter selection",-1,cluedo.scanCharicter());
	   
	   System.setIn(new ByteArrayInputStream("a".getBytes()));
	   Assert.assertEquals("Test invalid charicter selection",-1,cluedo.scanCharicter());
	   
	   System.setIn(new ByteArrayInputStream("3".getBytes()));
	   Assert.assertEquals("Test number players selection",3,cluedo.scanNumberPlayers());
	   
	   System.setIn(new ByteArrayInputStream("90".getBytes()));
	   Assert.assertEquals("Test incorrect number players selection",-1,cluedo.scanNumberPlayers());
	   
	   System.setIn(new ByteArrayInputStream("e".getBytes()));
	   Assert.assertEquals("Test invalid number players selection",-1,cluedo.scanNumberPlayers());
	   
	   Assert.assertTrue("Test for Duplicates",cluedo.checkDuplicate("Player"));
	   Assert.assertFalse("Test for Duplicates",cluedo.checkDuplicate("Cian"));
	   
	   System.setIn(new ByteArrayInputStream("Cian".getBytes()));
	   Assert.assertEquals("Test scan name","Cian",cluedo.scanPlayerName(1));
	   }
	@Test
	public void testMap(){
		map=new Map();
		map.checkMap();
	}
	
	@After	
	public void tearDown(){	
		board.rooms.remove(room);
		cluedo.pawns.remove(charPawn);
		CharPawn charPawn = null;
		WeaponPawn weaponPawn=null;
		CharCard charCard=null;
		WeaponCard weaponCard=null;
		Room room=null;
		Board board=null;
		System.out.println("Tear Down");	
	}	
	
	@AfterClass
	public static void AfterClass(){	
		 System.out.println("AfterClass");	
	}

}
