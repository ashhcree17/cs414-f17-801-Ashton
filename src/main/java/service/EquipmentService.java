package main.globoGymMS.service;

import java.util.List;

import main.java.globoGymMS.model.Equipment;

public interface EquipmentService {
	public void addEquipment(Equipment equipment);
	public List<Equipment> listInventory(); // name ????
	public Equipment getEquipment(int equipmentId);
	public void deleteEquipment(Equipment equipment);
}
