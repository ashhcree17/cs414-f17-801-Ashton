package csu.springmvc.service;

//import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
//import java.util.List;
//import org.junit.Assert;
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

  Address address1 = new Address();

  @Before
  public void setUp() throws Exception {
    address1.setAddressid(12766);
    address1.setStreet1("123 Main St");
    address1.setStreet2("Apt 123");
    address1.setCity("Denver");
    address1.setState("CO");
    address1.setZipcode(12345);
    
    addressService.createAddress(address1);
  }

  @Test
  public void testValidateAddress() {
    Address addressChk = addressService.getAddress(address1.getAddressid());

    assertEquals("123 Main St", addressChk.getStreet1());
  }

//  @Test
//  public void testlistAddresses() {
//    List<Address> listAddressChk = addressService.listAddresses();
//    Assert.assertThat(listAddressChk, hasItems(address1, address2));
////    assertEquals("123 Main St", listAddressChk);
//  }
}
