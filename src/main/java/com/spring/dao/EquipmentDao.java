package com.spring.dao;

import java.util.List;

import com.spring.model.Equipment;

public interface EquipmentDao {
	public void addEquipment(Equipment equipment);
	public void updateEquipment(Equipment equipment);	
	public List<Equipment> listInventory();
	public Equipment getEquipment(int equipmentId);
	public void deleteEquipment(int equipmentId);
}
