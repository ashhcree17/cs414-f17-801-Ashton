package service;

import java.util.List;

import model.Equipment;

public interface EquipmentService {
	public void addEquipment(Equipment equipment);
	public void updateEquipment(Equipment equipment);	
	public List<Equipment> listInventory();
	public Equipment getEquipment(int equipmentId);
	public void deleteEquipment(Equipment equipment);
}
