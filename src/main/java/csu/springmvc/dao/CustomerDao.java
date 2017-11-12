package csu.springmvc.dao;

import csu.springmvc.model.Customer;

public interface CustomerDao {

  void register(Customer customer);
  Customer getCustomer(int customerid);

}
