package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
	protected List<Card> charCards;
	protected List<Card> weaponCards;
	protected List<Card> roomCards;
	public Notebook(){
		
		
	}
	
    public void HypoNotebook(CharPawn A, CharPawn C, CharPawn E, WeaponPawn B, Card D){
    	System.out.println("I formulated the hypothesis that"+E+" made the murder in the"+A.Getposition()+" with the"+B.Getname());
    	System.out.println(C+"refuted the hypothesis showing the card"+D);//Need to be modified!
    }
    public void DefeNotebook(CharPawn C, CharPawn A, CharPawn E, WeaponPawn B, Card D,String name){
    	System.out.println(A+"formulated the hypothesis that"+E+"  made the murder in the "+A.Getposition()+" with the"+B.Getname());
    	System.out.println("I refuted the hypothesis showing card"+D);//need to be modified!
    }
    public void EverNotebook(CharPawn A, CharPawn C, CharPawn E, WeaponPawn B){
    	System.out.println(A+"made the hypothesis that"+E+"made the murder in the "+A.Getposition()+" with the"+B.Getname());
    	System.out.println(C+"refuted the hypothesis showing a card");
    }
		
	

}
