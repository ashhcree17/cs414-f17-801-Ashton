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

import com.spring.model.Address;
import com.spring.service.AddressService;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressServiceImplTest {
	
	@Autowired
	private AddressService addressService;

    Address address1 = new Address();
    Address address2 = new Address();
	
	@Before
	public void setup() {
        address1.setAddressId(111);
        address1.setStreet1("11 Main St");
        address1.setStreet2("Apt 1");
        address1.setCity("Niceville");
        address1.setState("FL");
        address1.setZipCode(12345);

        address2.setAddressId(222);
        address2.setStreet1("12 Main St");
        address2.setStreet2("Apt 2");
        address2.setCity("Meanville");
        address2.setState("FL");
        address2.setZipCode(54321);
	}
    
   @Test
   @Transactional
   @Rollback(true)
   public void testAddAddress() {
   		addressService.addAddress(address1);
		Assert.assertNotNull(addressService.getAddress(address1.getAddressId()));
   }
   
   @Test
   @Transactional
   @Rollback(true)
   public void testDeleteAddress() {
		addressService.addAddress(address1);
		addressService.addAddress(address2);

		addressService.deleteAddress(address1.getAddressId());
		Assert.assertNull(addressService.getAddress(address1.getAddressId()));
		Assert.assertNotNull(addressService.getAddress(address2.getAddressId()));
   }
}