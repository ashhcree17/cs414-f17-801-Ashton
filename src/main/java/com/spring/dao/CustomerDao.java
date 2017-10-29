package com.spring.dao;

import java.util.List;

import com.spring.model.Customer;

public interface CustomerDao {
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public List<Customer> listCustomers();
	public Customer getCustomer(int id);
	public void deleteCustomer(Customer customer);
}