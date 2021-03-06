package csu.springmvc.service;

import java.util.List;

import csu.springmvc.model.Customer;

public interface CustomerService {

  void createCustomer(Customer customer);
  Customer getCustomer(int customerid);
  List<Customer> listCustomers();
}
