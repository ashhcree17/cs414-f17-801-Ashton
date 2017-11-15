package csu.springmvc.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.dao.AddressDao;
import csu.springmvc.model.Address;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressDaoImplTest {
  
  @Autowired
  private AddressDao addressDao;

  Address address1 = new Address();
  Address address2 = new Address();

  @Before
  public void setup() {
      address1.setAddressid(726);
      address1.setStreet1("11 Main St");
      address1.setStreet2("Apt 1");
      address1.setCity("Niceville");
      address1.setState("FL");
      address1.setZipcode(12345);

      address2.setAddressid(727);
      address2.setStreet1("12 Main St");
      address2.setStreet2("Apt 2");
      address2.setCity("Meanville");
      address2.setState("FL");
      address2.setZipcode(54321);
  }
  
  @Test
  public void testAddAddress() {
      addressDao.addAddress(address1);
      
      Assert.assertEquals("11 Main St", 
          addressDao.getAddress(address1.getAddressid()).getStreet1());
  }
  
}
