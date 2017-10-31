package com.spring.modelTest;

//import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
//import junit.framework.Assert;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//import com.spring.dao.EquipmentDao;
//import com.spring.model.Equipment;
//import com.spring.model.MembershipStatus;

@RunWith(SpringJUnit4ClassRunner.class)
public class EquipmentModelTest {
     
//    @Autowired
//    private EquipmentDao equipmentDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddEquipment() {
//        Equipment equipment = new Equipment();
//        equipment.setEquipmentId(1);
//        equipment.setName("name");
//        equipment.setLastName("lastName");
//        equipment.setEquipmentEquipmentId(12);
//        equipment.setPhoneNumber(1234567890);
//        equipment.setEmail("email@email.com");
//        equipment.setInsurance("Aetna");
//        equipment.setMembership(MembershipStatus.ACTIVE);
//        equipmentDao.addEquipment(equipment);
//         
//        List<Equipment> equipments = equipmentDao.listEquipments();
//         
//        Assert.assertEquals(1, equipments.size());         
//        Assert.assertEquals(equipment.getName(), equipments.get(0).getName());
    }
}