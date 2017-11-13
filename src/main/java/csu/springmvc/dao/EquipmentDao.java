package csu.springmvc.dao;

import csu.springmvc.model.Equipment;

public interface EquipmentDao {

  void register(Equipment equipment);
  Equipment getEquipment(int equipmentid);

}
