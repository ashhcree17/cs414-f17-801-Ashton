package csu.springmvc.service;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.model.Login;
import csu.springmvc.model.Manager;
import csu.springmvc.service.ManagerService;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ManagerServiceTest {

  @Autowired
  ManagerService managerService;

  Manager manager = new Manager();
  
  @Before
  public void setUp() throws Exception {
    manager.setManagerid(5967);
    manager.setUsername("joesmith");
    manager.setPassword("iLOVEtheGYM21");
    manager.setName("Joe");
    manager.setLastname("Smith");
    manager.setPhonenumber(1234567890);
    manager.setEmail("joesmith@email.com");
    manager.setInsurance("Aetna");
    managerService.createManager(manager);
  }

  @Test
  public void testValidateUser() {
    Login login = new Login();
    login.setUsername("joesmith");
    login.setPassword("iLOVEtheGYM21");

    Manager managerChk = managerService.validateManager(login);

    assertEquals("Joe", managerChk.getName());
  }
}
