package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;

public class Board extends Game{
	protected List<Room> rooms;
	
	public Board() {
		rooms = new ArrayList<Room>();
	}
	public void createRooms(){
		Room ballroom = new Room(0,"Ballroom");
		Room conservatory = new Room(6,"Conservatory");
		Room billiard = new Room(12,"Billiard Room");
		Room library = new Room(18,"Library");
		Room study = new Room(24,"Study");
		Room hall = new Room(30,"Hall");
		Room lounge = new Room(36,"Lounge");
		Room dining = new Room(42,"Dining Room");
		Room kitchen = new Room(48,"Kitchen");
		rooms.add(kitchen);
		rooms.add(ballroom);
		rooms.add(conservatory);
		rooms.add(dining);
		rooms.add(lounge);
		rooms.add(hall);
		rooms.add(study);
		rooms.add(billiard);
		rooms.add(library);		
	}
	
	public List<Pawn> checkRoom(Game game,Room room){
		pawnList.clear();
		for (int i=0; i< game.pawns.size();i++) {
			if (game.pawns.get(i).getPosition()==room.getPosition()) {
				pawnList.add(game.pawns.get(i));
			}
		}
		return pawnList;
	}
	
	public Room findRoom(int loc){
		Room room=null;
		for(int t=0;t<rooms.size();t++){
			if(rooms.get(t).position==loc){
				 room=rooms.get(t);
			}
		}
		return room;		
	}
}
