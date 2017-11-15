package csu.springmvc.dao;

import csu.springmvc.model.Equipment;

public interface EquipmentDao {

  void addEquipment(Equipment equipment);
  Equipment getEquipment(int equipmentid);
}
