package csu.springmvc.service;

import csu.springmvc.model.Equipment;

public interface EquipmentService {

  void register(Equipment equipment);
  Equipment getEquipment(int equipmentid);
}
