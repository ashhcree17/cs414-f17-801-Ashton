package csu.springmvc;

//import static org.junit.Assert.assertEquals;
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

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testValidateUser() {

    Login login = new Login();
    login.setUsername("ranjith");
    login.setPassword("sekar");

    Manager manager = managerService.validateManager(login);

//    assertEquals("Ranjith", user.getFirstname());
  }

}
