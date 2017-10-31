package com.spring.modelTest;

//import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
//import junit.framework.Assert;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//import com.spring.dao.CustomerDao;
//import com.spring.model.Customer;
//import com.spring.model.MembershipStatus;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerModelTest {
     
//    @Autowired
//    private CustomerDao customerDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddCustomer() {
//        Customer customer = new Customer();
//        customer.setCustomerId(1);
//        customer.setName("name");
//        customer.setLastName("lastName");
//        customer.setCustomerCustomerId(12);
//        customer.setPhoneNumber(1234567890);
//        customer.setEmail("email@email.com");
//        customer.setInsurance("Aetna");
//        customer.setMembership(MembershipStatus.ACTIVE);
//        customerDao.addCustomer(customer);
//         
//        List<Customer> customers = customerDao.listCustomers();
//         
//        Assert.assertEquals(1, customers.size());         
//        Assert.assertEquals(customer.getName(), customers.get(0).getName());
    }
}
package com.spring.modelTest;

//import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
//import junit.framework.Assert;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//import com.spring.dao.CustomerDao;
//import com.spring.model.Customer;
//import com.spring.model.MembershipStatus;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerModelTest {
     
//    @Autowired
//    private CustomerDao customerDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddCustomer() {
//        Customer customer = new Customer();
//        customer.setCustomerId(1);
//        customer.setName("name");
//        customer.setLastName("lastName");
//        customer.setCustomerCustomerId(12);
//        customer.setPhoneNumber(1234567890);
//        customer.setEmail("email@email.com");
//        customer.setInsurance("Aetna");
//        customer.setMembership(MembershipStatus.ACTIVE);
//        customerDao.addCustomer(customer);
//         
//        List<Customer> customers = customerDao.listCustomers();
//         
//        Assert.assertEquals(1, customers.size());         
//        Assert.assertEquals(customer.getName(), customers.get(0).getName());
    }
}