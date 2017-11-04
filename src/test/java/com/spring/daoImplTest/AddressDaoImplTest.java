package com.spring.daoImplTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.AddressDao;
import com.spring.model.Address;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressDaoImplTest {
     
    @Autowired
    private AddressDao addressDao;

    Address address1 = new Address();
    Address address2 = new Address();
    
    @Before
    public void setup() {
        address1.setAddressId(1);
        address1.setStreet1("11 Main St");
        address1.setStreet2("Apt 1");
        address1.setCity("Niceville");
        address1.setState("FL");
        address1.setZipCode(12345);

        address2.setAddressId(2);
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
    		addressDao.addAddress(address1);
    		Assert.assertNotNull(addressDao.getAddress(address1.getAddressId()));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteAddress() {
		addressDao.addAddress(address1);
        addressDao.addAddress(address2);

		addressDao.deleteAddress(address1.getAddressId());
        Assert.assertEquals(1, addressDao.listAddresses().size());
    }
}