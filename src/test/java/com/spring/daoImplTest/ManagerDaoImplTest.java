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

import com.spring.dao.ManagerDao;
import com.spring.model.Manager;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ManagerDaoImplTest {
     
    @Autowired
    private ManagerDao managerDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddManager() {
        Manager manager = new Manager();
        manager.setManagerId(1);
        manager.setUsername("username");
        manager.setPassword("password");
        manager.setName("name");
        manager.setLastName("lastName");
        manager.setManagerAddressId(123);
        manager.setPhoneNumber(1234567890);
        managerDao.addManager(manager);
         
        List<Manager> managers = managerDao.listManagers();
         
        Assert.assertEquals(1, managers.size());         
        Assert.assertEquals(manager.getName(), managers.get(0).getName());
    }
}