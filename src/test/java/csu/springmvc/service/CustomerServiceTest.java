package csu.springmvc.service;

import static org.junit.Assert.assertEquals;

//import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.model.Customer;
import csu.springmvc.service.CustomerService;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

  @Autowired
  CustomerService customerService;

  Customer customer = new Customer();

  @Before
  public void setUp() throws Exception {
    customer.setCustomerid(2677);
    customer.setName("Joe");
    customer.setLastname("Smith");
    customer.setPhonenumber(1234567890);
    customer.setEmail("joesmith@email.com");
    customer.setInsurance("Aetna");
    customer.setMembership("ACTIVE");
    customerService.createCustomer(customer);
  }

  @Test
  public void testValidateCustomer() {
    Customer customerChk = customerService.getCustomer(customer.getCustomerid());

    assertEquals("Joe", customerChk.getName());
  }

//  @Test
//  public void testlistCustomers() {
//    List<Customer> listCustomerChk = customerService.listCustomers();
//    assertEquals("123 Main St", listCustomerChk);
//  }
}
