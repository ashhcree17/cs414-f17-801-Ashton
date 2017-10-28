package main.globoGymMS.dao;

import java.util.List;

import main.globoGymMS.model.Equipment;

public interface EquipmentDao {
	public void addEquipment(Equipment equipment);
	public List<Equipment> listInventory(); // name ????
	public Equipment getEquipment(int equipmentId);
	public void deleteEquipment(Equipment equipment);
}
