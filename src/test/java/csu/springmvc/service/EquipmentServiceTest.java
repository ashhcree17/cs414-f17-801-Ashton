package csu.springmvc.service;

import static org.junit.Assert.assertEquals;

//import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.model.Equipment;
import csu.springmvc.service.EquipmentService;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class EquipmentServiceTest {

  @Autowired
  EquipmentService equipmentService;

  Equipment equipment = new Equipment();

  @Before
  public void setUp() throws Exception {
    equipment.setEquipmentid(90226);
    equipment.setName("Barbell");
//    equipment.setPicture(null);
    equipment.setQuantity(12);
    equipmentService.createEquipment(equipment);
  }

  @Test
  public void testValidateEquipment() {
    Equipment equipmentChk = equipmentService.getEquipment(equipment.getEquipmentid());
    assertEquals("Barbell", equipmentChk.getName());
  }

//  @Test
//  public void testlistEquipment() {
//    List<Equipment> listEquipmentChk = equipmentService.listEquipment();
//    assertEquals("123 Main St", listEquipmentChk);
//  }
}
