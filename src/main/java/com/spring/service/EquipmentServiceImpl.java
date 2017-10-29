package com.spring.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EquipmentDao;
import com.spring.model.Equipment;

import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	private EquipmentDao equipmentDao;

	public void setEquipmentDao(EquipmentDao equipmentDao) {
		this.equipmentDao = equipmentDao;
	}
	
	@Override
	@Transactional
	public void addEquipment(Equipment equipment) {
		equipmentDao.addEquipment(equipment);
	}

	@Override
	@Transactional
	public void updateEquipment(Equipment equipment) {
		equipmentDao.updateEquipment(equipment);
	}
	
	@Override
	@Transactional
	public List<Equipment> listInventory() {
		return equipmentDao.listInventory();
	}
	
	@Override
	@Transactional
	public Equipment getEquipment(int equipmentId) {
		return equipmentDao.getEquipment(equipmentId);
	}
	
	@Override
	@Transactional
	public void deleteEquipment(int equipmentId) {
		equipmentDao.deleteEquipment(equipmentId);
	}
}
