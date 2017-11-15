package csu.springmvc.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.dao.EquipmentDao;
import csu.springmvc.model.Equipment;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class EquipmentDaoImplTest {
  
  @Autowired
  private EquipmentDao equipmentDao;

  Equipment equipment1 = new Equipment();
  Equipment equipment2 = new Equipment();

  @Before
  public void setup() {
      equipment1.setEquipmentid(3);
      equipment1.setName("Barbell");
      equipment1.setQuantity(6);

      equipment2.setEquipmentid(4);
      equipment2.setName("Dumbbell");
      equipment2.setQuantity(20);
  }
  
  @Test
  public void testAddEquipment() {
      equipmentDao.addEquipment(equipment1);
      
      Assert.assertEquals("Barbell", 
          equipmentDao.getEquipment(equipment1.getEquipmentid()).getName());
  }
  
}
