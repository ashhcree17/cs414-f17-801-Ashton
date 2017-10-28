package main.globoGymMS.service;

import java.util.List;

import main.java.globoGymMS.model.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);
	public List<Customer> listCustomers();
	public Customer getCustomer(int id);
	public void deleteCustomer(Customer customer);
}
