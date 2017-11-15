package csu.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.CustomerDao;
import csu.springmvc.model.Customer;

public class CustomerServiceImpl implements CustomerService {

  @Autowired
  public CustomerDao customerDao;

  public void register(Customer customer) {
    customerDao.addCustomer(customer);
  }

  public Customer getCustomer(int customerid) {
    return customerDao.getCustomer(customerid);
  }

  public List<Customer> listCustomers() {
    return customerDao.listCustomers();
  }
}
