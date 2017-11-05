package com.spring.serviceImplTest;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Equipment;
import com.spring.service.EquipmentService;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EquipmentServiceImplTest {
	
	@Autowired
	private EquipmentService equipmentService;

    Equipment equipment1 = new Equipment();
    Equipment equipment2 = new Equipment();
	
	@Before
	public void setup() {
        equipment1.setEquipmentId(111);
        equipment1.setName("Equip1");
        equipment1.setQuantity(2);
        equipment1.setExercises(null);

        equipment2.setEquipmentId(222);
        equipment1.setName("Equip2");
        equipment1.setQuantity(4);
        equipment1.setExercises(null);
	}
    
   @Test
   @Transactional
   @Rollback(true)
   public void testAddEquipment() {
   		equipmentService.addEquipment(equipment1);
		Assert.assertNotNull(equipmentService.getEquipment(equipment1.getEquipmentId()));
   }
   
   @Test
   @Transactional
   @Rollback(true)
   public void testDeleteEquipment() {
		equipmentService.addEquipment(equipment1);
		equipmentService.addEquipment(equipment2);

		equipmentService.deleteEquipment(equipment1.getEquipmentId());
		Assert.assertNull(equipmentService.getEquipment(equipment1.getEquipmentId()));
		Assert.assertNotNull(equipmentService.getEquipment(equipment2.getEquipmentId()));
   }
}