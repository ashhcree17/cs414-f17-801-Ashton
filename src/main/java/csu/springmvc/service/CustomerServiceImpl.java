package csu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.CustomerDao;
import csu.springmvc.model.Customer;

public class CustomerServiceImpl implements CustomerService {

  @Autowired
  public CustomerDao customerDao;

  public void register(Customer customer) {
    customerDao.register(customer);
  }

  public Customer getCustomer(int customerid) {
    return customerDao.getCustomer(customerid);
  }
}
