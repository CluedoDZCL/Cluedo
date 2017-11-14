package ie.ucd.cluedo;

import java.util.ArrayList;

public class WeaponCard extends Card{
		String name;
	public WeaponCard(String name) {
		String type = "Weapon";
		this.name=name;
	}
   public String getName(){
	   return name;
   }
}