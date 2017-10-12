

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Equipment> equipment;

	// Creates an Inventory instance and sets its attributes
	public Inventory(ArrayList<Equipment> equipment) {
		super();
		this.equipment = equipment;
	}
	
	/* Start of getters & setters */
	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}
	/* End of getters & setters */
}
