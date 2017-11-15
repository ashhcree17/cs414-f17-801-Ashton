package csu.springmvc.dao;

import java.util.List;

import csu.springmvc.model.Customer;

public interface CustomerDao {

  void addCustomer(Customer customer);
  Customer getCustomer(int customerid);
  List<Customer> listCustomers();
}
