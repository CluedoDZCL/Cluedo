package ie.ucd.cluedo;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
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
	Room room=null;
	Board board=null;
	Game cluedo=null;
	Player player=null;
	Player player2=null;
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
		cluedo.users.get(0).playerCards.add(charCard);
		Assert.assertTrue("Test check player has card",player.contains(charCard));
		//raiseAccusation()
		//processAccusation()
		//movement()
		player.initializeNotebook();
		//printNotebook()
		//checkCards
		//printCards
		
	}
	
	@Test	
	public void testHypothesis(){
		//makeHypothesis(Plyer,Game,Board)
		//processHypothesis()
		//movePawn(Pawn,int)
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
	   Assert.assertEquals("Test charicter selection","Miss Scarlett",player.character.getName());
	   		
		//cluedo.creatPlayer();
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
