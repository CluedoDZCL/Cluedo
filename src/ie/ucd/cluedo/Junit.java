package ie.ucd.cluedo;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;

class Junit {
	CharPawn charPawn = null;
	WeaponPawn weaponPawn=null;
	CharCard charCard=null;
	WeaponCard weaponCard=null;
	Room room=null;
	Board board=null;
	Game cluedo=null;

	@BeforeClass
	public	static	void	BeforeClass(){	
		 	//initialise variables
		 	System.out.println("BeforeClass");	
	}	
	
	@Before	
	public void setUp() throws Exception{	
		charPawn = new CharPawn("Charicter", 15);
		weaponPawn = new WeaponPawn("Weapon",18);
		charCard= new CharCard("Charicter");
		weaponCard= new WeaponCard("Weapon");
		room= new Room(30,"Room");
		board= new Board();
		cluedo= new Game();
		System.out.println("setUp");	
	}
	
	@Test	
	public void testCharPawn(){
		Assert.assertEquals("Test position Constructor", 15,	charPawn.getPosition(),	0);	
		charPawn.setPosition(30);
		Assert.assertEquals("Test position setter", 30,	charPawn.getPosition(),	0);	
		charPawn.setPosition(60);
		Assert.assertEquals("Test modulus position", 6,	charPawn.getPosition(),	0);
		charPawn.setPosition(-10);
		Assert.assertEquals("Test modulus position", 44, charPawn.getPosition(),	0);
	}
	
	@Test	
	public void testWeaponPawn(){
		Assert.assertEquals("Test position Constructor", 18,	weaponPawn.getPosition(),	0);	
		weaponPawn.setPosition(30);
		Assert.assertEquals("Test position setter", 30,	weaponPawn.getPosition(),	0);	
		weaponPawn.setPosition(60);
		Assert.assertEquals("Test positive modulus position", 6,	weaponPawn.getPosition(),	0);
		weaponPawn.setPosition(-10);
		Assert.assertEquals("Test negitive modulus position", 44,	weaponPawn.getPosition(),	0);
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
		Assert.assertEquals("Test position Constructor", 30,room.getPosition());	
	}
	
	@Test	
	public void testBoard(){
		charPawn.setPosition(30);
		Assert.assertTrue("Test check pawn in room",board.checkRoomPawn(charPawn,room));
		charPawn.setPosition(35);
		Assert.assertFalse("Test check pawn in room",board.checkRoomPawn(charPawn,room));
		
		//checkRoom(cluedo,room);
		
		Assert.assertEquals("Test position Constructor","Hall",board.findRoomName(30));
		
	}
	
	@After	
	public void tearDown(){	
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
