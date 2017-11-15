package csu.springmvc.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.dao.CustomerDao;
import csu.springmvc.model.Customer;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDaoImplTest {
  
  @Autowired
  private CustomerDao customerDao;

  Customer customer1 = new Customer();
  Customer customer2 = new Customer();

  @Before
  public void setup() {
    customer1.setCustomerid(1);
    customer1.setName("Dude");
    customer1.setLastname("Customerman");
    customer1.setPhonenumber(1234567890);
    customer1.setEmail("customerdude@email.com");
    customer1.setInsurance("Aetna");
    customer1.setMembership("ACTIVE");

    customer2.setCustomerid(2);
    customer2.setName("Customer");
    customer2.setLastname("Dudeman");
    customer2.setPhonenumber(1234567890);
    customer2.setEmail("dudecustomer@email.com");
    customer2.setInsurance("Aetna");
    customer1.setMembership("ACTIVE");
  }
  
  @Test
  public void testAddCustomer() {
      customerDao.addCustomer(customer1);
      
      Assert.assertEquals("Dude", 
          customerDao.getCustomer(customer1.getCustomerid()).getName());
  }
  
}
