package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.EquipmentDao;
import model.Equipment;

import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	private EquipmentDao equipmentDao;
	
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
	public void deleteEquipment(Equipment equipment) {
		equipmentDao.deleteEquipment(equipment);
	}
}
