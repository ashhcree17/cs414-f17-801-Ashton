package csu.springmvc.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.dao.ManagerDao;
import csu.springmvc.model.Manager;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ManagerDaoImplTest {
  
  @Autowired
  private ManagerDao managerDao;

  Manager manager1 = new Manager();
  Manager manager2 = new Manager();

  @Before
  public void setup() {
      manager1.setManagerid(676);
      manager1.setUsername("managerdude");
      manager1.setPassword("iLOVEtoTRAIN100");
      manager1.setName("Dude");
      manager1.setLastname("Managerman");
      manager1.setPhonenumber(1234567890);
      manager1.setEmail("managerdude@email.com");
      manager1.setInsurance("Aetna");

      manager2.setManagerid(677);
      manager2.setUsername("dudemanager");
      manager2.setPassword("iLOVEtoTRAIN100");
      manager2.setName("Manager");
      manager2.setLastname("Dudeman");
      manager2.setPhonenumber(1234567890);
      manager2.setEmail("dudemanager@email.com");
      manager2.setInsurance("Aetna");
  }
  
  @Test
  public void testAddManager() {
      managerDao.addManager(manager1);
      
      Assert.assertEquals("Dude", 
          managerDao.getManager(manager1.getManagerid()).getName());
  }
  
}
