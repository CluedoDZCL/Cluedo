package ie.ucd.cluedo;

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
		
	    //Create player
		cluedo.creatPlayer();
	    
		//Distribute cards
		cluedo.distributeCards();
		
		/*check setup correct 
		for (int i=0; i<cluedo.users.size();i++) {
			
			String name=cluedo.users.get(i).getName();
			String character=cluedo.users.get(i).getCharacter().getName();
			System.out.println(name + " is using pawn " + character);
			System.out.println(name + " has the following cards;");
			for (int j=0; j<cluedo.users.get(i).playerCards.size();j++) {
				name=cluedo.users.get(i).playerCards.get(j).getName();
				System.out.println(name +", ");
			}
		}
		System.out.println("The mystery is " + cluedo.mystery.get(0).getName() + " in the "
				+ cluedo.mystery.get(1).getName()+ " with the " + cluedo.mystery.get(2).getName());
		*/
		/*
		//check moving
		Board board = new Board();
		board.createRooms();
		
		System.out.println(cluedo.users.get(0).getCharacter().getPosition());
		cluedo.users.get(0).movement();
		System.out.println(cluedo.users.get(0).getCharacter().getPosition());
		
		cluedo.users.get(0).getCharacter().setPosition(20);
		cluedo.weaponPawn.get(1).setPosition(20);
		cluedo.weaponPawn.get(3).setPosition(20);
		int size=board.checkRoom(cluedo,board.rooms.get(1)).size();
		for (int i=0; i<size;i++) {
			System.out.println(board.checkRoom(cluedo,board.rooms.get(1)).get(i).getName());
		}
		*/

	     cluedo.startGame(cluedo, hepo, apartment);
		
		//cluedo.users.get(0).character.setPosition(20);
		//System.out.println(apartment.findRoomName(cluedo.users.get(0).character.getPosition()));
		
		System.out.println("Finished main");
	}
}
