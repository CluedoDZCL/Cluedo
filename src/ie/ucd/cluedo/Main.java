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
		
		
		for (int i=0; i<cluedo.users.size();i++) {
			
			String name=cluedo.users.get(i).getName();
			String character=cluedo.users.get(i).getCharacter();
			System.out.println(name + " is using pawn " + character);
			System.out.println(name + " has the following cards;");
			for (int j=0; j<cluedo.users.get(i).playerCards.size();j++) {
				name=cluedo.users.get(i).playerCards.get(j).getName();
				System.out.println(name +", ");
			}
		}
		System.out.println("The mystery is " + cluedo.mystery.get(0).getName() + " in the "
				+ cluedo.mystery.get(1).getName()+ " with the " + cluedo.mystery.get(2).getName());
		
		
		System.out.println("Finished main");
	}
}
