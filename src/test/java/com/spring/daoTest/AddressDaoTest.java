package com.spring.controllerTest;

import java.util.List;
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

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressDaoTest {
     
    @Autowired
    private AddressDao addressDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddAddress() {
        Address address = new Address();
        address.setAddressId(1);
        address.setUsername("username");
        address.setPassword("password");
        address.setName("name");
        address.setLastName("lastName");
        address.setAddressAddressId(123);
        address.setPhoneNumber(1234567890);
        addressDao.addAddress(address);
         
        List<Address> addresss = addressDao.listAddresses();
         
        Assert.assertEquals(1, addresss.size());         
        Assert.assertEquals(address.getName(), addresss.get(0).getName());
    }
}