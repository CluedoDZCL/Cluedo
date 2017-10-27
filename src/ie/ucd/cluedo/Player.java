package ie.ucd.cluedo;

public class Player {
	
	public Player(){
		
	}
    public void Hypothesis(CharPawn A, CharPawn E, WeaponPawn B, Card D){
    	System.out.println("I formulated the hypothesis that"+E+" made the murder in the"+A.Getposition()+" with the"+B.Getname());
    	
    }
    public void Accusation(CharPawn A, CharPawn E, WeaponPawn B, Card D){
    	System.out.println("I formulated the accusation that"+E+" made the murder in the"+A.Getposition()+" with the"+B.Getname());
    }
}
