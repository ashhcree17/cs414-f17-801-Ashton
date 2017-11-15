package csu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.EquipmentDao;
import csu.springmvc.model.Equipment;

public class EquipmentServiceImpl implements EquipmentService {

  @Autowired
  public EquipmentDao equipmentDao;

  public void register(Equipment equipment) {
    equipmentDao.addEquipment(equipment);
  }

  public Equipment getEquipment(int equipmentid) {
    return equipmentDao.getEquipment(equipmentid);
  }
}
