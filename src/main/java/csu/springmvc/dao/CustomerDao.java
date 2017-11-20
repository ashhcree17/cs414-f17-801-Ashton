package csu.springmvc.dao;

import java.util.List;

import csu.springmvc.model.Customer;

public interface CustomerDao {

  void createCustomer(Customer customer);
  Customer getCustomer(int customerid);
  List<Customer> listCustomers();
}
