package csu.springmvc;

import static org.junit.Assert.assertEquals;
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
    equipment.setEquipmentid(2144);
    equipment.setName("Barbell");
//    equipment.setPicture(null);
    equipment.setQuantity(12);
    equipmentService.register(equipment);
  }

  @Test
  public void testValidateEquipment() {
    Equipment equipmentChk = equipmentService.getEquipment(equipment.getEquipmentid());

    assertEquals("Barbell", equipmentChk.getName());
  }
}
