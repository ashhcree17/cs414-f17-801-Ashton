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

import com.spring.dao.CustomerDao;
import com.spring.model.Customer;
import com.spring.model.MembershipStatus;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDaoImplTest {
     
    @Autowired
    private CustomerDao customerDao;
    
    Customer customer1 = new Customer();
    Customer customer2 = new Customer();
    
    @Before
    public void setup() {
        customer1.setCustomerId(1);
        customer1.setName("Joe");
        customer1.setLastName("Smith");
        customer1.setCustomerAddressId(1);
        customer1.setPhoneNumber(1234567890);
        customer1.setEmail("joe@email.com");
        customer1.setInsurance("Aetna");
        customer1.setMembership(MembershipStatus.ACTIVE);

        customer2.setCustomerId(2);
        customer1.setName("John");
        customer1.setLastName("Paul");
        customer1.setCustomerAddressId(2);
        customer1.setPhoneNumber(1234567899);
        customer1.setEmail("john@email.com");
        customer1.setInsurance("Aetna");
        customer1.setMembership(MembershipStatus.ACTIVE);
    }
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddCustomer() {
    		customerDao.addCustomer(customer1);
    		Assert.assertNotNull(customerDao.getCustomer(customer1.getCustomerId()));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteCustomer() {
		customerDao.addCustomer(customer1);
        customerDao.addCustomer(customer2);

		customerDao.deleteCustomer(customer1.getCustomerId());
		Assert.assertNull(customerDao.getCustomer(customer1.getCustomerId()));
		Assert.assertNotNull(customerDao.getCustomer(customer2.getCustomerId()));
    }
}