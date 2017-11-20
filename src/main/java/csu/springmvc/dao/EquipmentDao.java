package csu.springmvc.dao;

import java.util.List;

import csu.springmvc.model.Equipment;

public interface EquipmentDao {

  void createEquipment(Equipment equipment);
  Equipment getEquipment(int equipmentid);
  List<Equipment> listEquipment();
}
