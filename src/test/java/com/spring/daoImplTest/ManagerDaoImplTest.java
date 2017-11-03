package com.spring.daoImplTest;

import java.util.List;
import org.junit.Before;
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

@ContextConfiguration(locations = "classpath:servlet-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ManagerDaoImplTest {
     
    @Autowired
    private ManagerDao managerDao;
    
    Manager manager1 = new Manager();
    Manager manager2 = new Manager();
    
    @Before
    public void setup() {
        manager1.setManagerId(1);
        manager1.setUsername("joe.smith");
        manager1.setPassword("gymRAT123");
        manager1.setName("Joe");
        manager1.setLastName("Smith");
        manager1.setManagerAddressId(1);
        manager1.setPhoneNumber(1234567890);
        manager1.setEmail("joe@email.com");
        manager1.setInsurance("Aetna");

        manager2.setManagerId(2);
        manager1.setUsername("john.tucker");
        manager1.setPassword("GYMrat321");
        manager1.setName("John");
        manager1.setLastName("Tucker");
        manager1.setManagerAddressId(2);
        manager1.setPhoneNumber(1234567890);
        manager1.setEmail("john@email.com");
        manager1.setInsurance("Aetna");
    }
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddManager() {
		List<Manager> managers = managerDao.listManagers();

		managerDao.addManager(manager1);
	    Assert.assertEquals(1, managers.size());         
			
	    managerDao.addManager(manager2);
	    Assert.assertEquals(2, managers.size());         
		 
	    Assert.assertEquals(manager1.getName(), managers.get(0).getName());
	}
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteManager() {
		managerDao.addManager(manager1);
        managerDao.addManager(manager2);

		managerDao.deleteManager(manager1.getManagerId());
        Assert.assertEquals(1, managerDao.listManagers().size());
    }
}