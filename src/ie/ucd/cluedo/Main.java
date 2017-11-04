package ie.ucd.cluedo;

public class Main {
	public static void main (String[] args) {
		
		//Create Board, Cards, Pawns and mystery
		Game cluedo = new Game();
		cluedo.createCards();	
		cluedo.createMystery();	
		cluedo.createPawns();
		
	    //Create player
		cluedo.creatPlayer();
	    
		//Distribute cards
		cluedo.distributeCards();
		
		System.out.println("Finished main");
	}
}
