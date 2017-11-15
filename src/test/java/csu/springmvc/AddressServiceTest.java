package csu.springmvc;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.model.Address;
import csu.springmvc.service.AddressService;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressServiceTest {

  @Autowired
  AddressService addressService;

  Address address = new Address();

  @Before
  public void setUp() throws Exception {
    address.setAddressid(2194);
    address.setStreet1("123 Main St");
    address.setStreet2("Apt 123");
    address.setCity("Denver");
    address.setState("CO");
    address.setZipcode(12345);
    addressService.register(address);
  }

  @Test
  public void testValidateAddress() {
    Address addressChk = addressService.getAddress(address.getAddressid());

    assertEquals("123 Main St", addressChk.getStreet1());
  }
}
