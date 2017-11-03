package com.spring.daoImplTest;

import java.util.List;
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

@ContextConfiguration(locations = "classpath:servlet-context-test.xml")
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
    		List<Address> addresses = addressDao.listAddresses();

    		addressDao.addAddress(address1);
        Assert.assertEquals(1, addresses.size());         
    		
        addressDao.addAddress(address2);
        Assert.assertEquals(2, addresses.size());         
		 
        Assert.assertEquals(address1.getStreet1(), addresses.get(0).getStreet1());
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