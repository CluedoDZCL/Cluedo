package ie.ucd.cluedo;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		//Create Board, Cards, Pawns and mystery
		Game cluedo = new Game();
		Board apartment=new Board();
		Hypothesis hepo=new Hypothesis();
		
		apartment.createRooms();
		cluedo.createCards();	
		cluedo.createMystery();	
		cluedo.createPawns();
		cluedo.creatPlayer();
	   	cluedo.distributeCards();
		
	    cluedo.startGame(cluedo, hepo, apartment);
		
		System.out.println("Finished main");
	}
}
