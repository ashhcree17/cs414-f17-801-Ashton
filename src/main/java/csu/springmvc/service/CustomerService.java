package csu.springmvc.service;

import csu.springmvc.model.Customer;

public interface CustomerService {

  void register(Customer customer);
  Customer getCustomer(int customerid);
}
