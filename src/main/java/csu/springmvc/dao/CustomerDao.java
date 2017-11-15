package csu.springmvc.dao;

import csu.springmvc.model.Customer;

public interface CustomerDao {

  void addCustomer(Customer customer);
  Customer getCustomer(int customerid);
}
