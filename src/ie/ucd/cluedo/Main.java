package ie.ucd.cluedo;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		//Create Board, Cards, Pawns and mystery
		Game cluedo = new Game();
		Board apartment=new Board();
		Hypothesis hepo=new Hypothesis();
		Map map=new Map();
	//	map.checkMap();
		
		apartment.createRooms();
		cluedo.createCards();	
		cluedo.createMystery();	
		cluedo.createPawns();
		cluedo.creatPlayer();
		System.out.println(cluedo.users.get(0).getName());
	   	cluedo.distributeCards();
	   	
		
	    cluedo.startGame(hepo, apartment);
		
		System.out.println("Finished main");
	}
}
