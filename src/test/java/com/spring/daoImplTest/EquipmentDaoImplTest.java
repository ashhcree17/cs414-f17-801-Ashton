package com.spring.daoImplTest;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EquipmentDao;
import com.spring.model.Equipment;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EquipmentDaoImplTest {
     
    @Autowired
    private EquipmentDao equipmentDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddEquipment() {
        Equipment equipment = new Equipment();
        equipment.setEquipmentId(1);
//        equipment.setPicture("name");
        equipment.setQuantity(5);
        equipmentDao.addEquipment(equipment);
         
        List<Equipment> equipments = equipmentDao.listInventory();
         
        Assert.assertEquals(1, equipments.size());         
        Assert.assertEquals(equipment.getName(), equipments.get(0).getName());
    }
}