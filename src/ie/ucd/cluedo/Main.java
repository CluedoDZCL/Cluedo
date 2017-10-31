package ie.ucd.cluedo;

import java.util.List;

public class Main {
	public static void main (String[] args) {
		
		//Create Board
		Game cluedo = new Game();
		//Create Cards
		cluedo.CreateCards();	
		//Create mystery
		cluedo.Mystery();	
		
		//Create Pawns	 
		cluedo.createPawns();
		
	    //Create player
	    
		
		System.out.println("Finished main");
 
	
	
	}
}
