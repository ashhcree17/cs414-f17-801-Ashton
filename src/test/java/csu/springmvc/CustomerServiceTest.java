package csu.springmvc;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.model.Customer;
import csu.springmvc.model.Login;
import csu.springmvc.service.CustomerService;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

  @Autowired
  CustomerService customerService;

  Customer customer = new Customer();

  @Before
  public void setUp() throws Exception {
    customer.setCustomerid(1544);
    customer.setFirstname("Joe");
    customer.setLastname("Smith");
    customer.setPhonenumber(1234567890);
    customer.setEmail("joesmith@email.com");
    customer.setInsurance("Aetna");
    customer.setMembership("ACTIVE");
    customerService.register(customer);
  }

  @Test
  public void testValidateUser() {
    Login login = new Login();
    login.setUsername("joesmith");
    login.setPassword("iLOVEtheGYM21");

    Customer customerChk = customerService.getCustomer(customer.getCustomerid());

    assertEquals("Joe", customerChk.getFirstname());
  }
}
