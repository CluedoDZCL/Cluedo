package ie.ucd.cluedo;

import java.util.List;

public class Board extends Game{
	 	
	public void createRooms(){
		Room kitchen = new Room(10,"Kitchen");
		Room ballroom = new Room(20,"Ballroom");
		Room conservatory = new Room(30,"Conservatory");
		Room dining = new Room(40,"Dining Room");
		Room lounge = new Room(50,"Lounge");
		Room hall = new Room(60,"Hall");
		Room study = new Room(70,"Study");
		Room billiard = new Room(80,"Billiard Room");
		Room library = new Room(90,"Library");
			
	}
	
	public boolean checkRoomPawn(Pawn pawn,Room room) {
		if (pawn.getPosition()==room.getPosition()) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Pawn> checkRoom(Game game,Room room){
		pawnList.clear();
		int position =room.getPosition();
		for (int i=0; i< game.weaponPawn.size();i++) {
			if (game.pawns.get(i).getPosition()==position) {
				pawnList.add(game.pawns.get(i));
			}
		}
		return pawnList;
	}
}
