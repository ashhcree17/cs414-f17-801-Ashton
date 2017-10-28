package main.globoGymMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import main.java.globoGymMS.dao.EquipmentDao;
import main.java.globoGymMS.model.Equipment;

@Service("equipmentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class EquipmentServiceImpl {
	@Autowired
	private EquipmentDao equipmentDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEquipment(Equipment equipment) {
		equipmentDao.addEquipment(equipment);
	}
	
	public List<Equipment> listInventory() {
		return equipmentDao.listInventory();
	}
	
	public Equipment getEquipment(int equipmentId) {
		return equipmentDao.getEquipment(equipmentId);
	}
	
	public void deleteEquipment(Equipment equipment) {
		equipmentDao.deleteEquipment(equipment);
	}
}
