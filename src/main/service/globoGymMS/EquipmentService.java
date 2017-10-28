package main.service.globoGymMS;

import java.util.List;
import main.model.globoGymMS.Equipment;

public interface EquipmentService {
	public void addEquipment(Equipment equipment);
	public List<Equipment> listInventory(); // name ????
	public Equipment getEquipment(int equipmentId);
	public void deleteEquipment(Equipment equipment);
}
