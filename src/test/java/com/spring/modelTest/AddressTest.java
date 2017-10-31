package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
//import junit.framework.Assert;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//import com.spring.dao.AddressDao;
//import com.spring.model.Address;
//import com.spring.model.MembershipStatus;

@RunWith(SpringJUnit4ClassRunner.class)
public class AddressTest {
	@Test
	public void typeAnnotations() {
    // assert
		AssertAnnotations.assertType(
				Address.class, Entity.class, Table.class);
  }
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddAddress() {
//        Address address = new Address();
//        address.setAddressId(1);
//        address.setName("name");
//        address.setLastName("lastName");
//        address.setAddressAddressId(12);
//        address.setPhoneNumber(1234567890);
//        address.setEmail("email@email.com");
//        address.setInsurance("Aetna");
//        address.setMembership(MembershipStatus.ACTIVE);
//        addressDao.addAddress(address);
//         
//        List<Address> addresss = addressDao.listAddresss();
//         
//        Assert.assertEquals(1, addresss.size());         
//        Assert.assertEquals(address.getName(), addresss.get(0).getName());
    }
}