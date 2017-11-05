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

import com.spring.model.Manager;
import com.spring.service.ManagerService;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ManagerServiceImplTest {
	
	@Autowired
	private ManagerService managerService;

    Manager manager1 = new Manager();
    Manager manager2 = new Manager();
	
	@Before
	public void setup() {
        manager1.setManagerId(111);
        manager1.setUsername("joe.smith");
        manager1.setPassword("gymRAT123");
        manager1.setName("Joe");
        manager1.setLastName("Smith");
        manager1.setManagerAddressId(1);
        manager1.setPhoneNumber(1234567890);
        manager1.setEmail("joe@email.com");
        manager1.setInsurance("Aetna");

        manager2.setManagerId(222);
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
   		managerService.addManager(manager1);
		Assert.assertNotNull(managerService.getManager(manager1.getManagerId()));
   }
   
   @Test
   @Transactional
   @Rollback(true)
   public void testDeleteManager() {
		managerService.addManager(manager1);
		managerService.addManager(manager2);

		managerService.deleteManager(manager1.getManagerId());
		Assert.assertNull(managerService.getManager(manager1.getManagerId()));
		Assert.assertNotNull(managerService.getManager(manager2.getManagerId()));
   }
}