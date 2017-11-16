package csu.springmvc.service;

import java.util.List;

import csu.springmvc.model.Equipment;

public interface EquipmentService {

  void register(Equipment equipment);
  Equipment getEquipment(int equipmentid);
  List<Equipment> listEquipment();
}
