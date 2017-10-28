package main.globoGymMS.dao;

import java.util.List;

import main.globoGymMS.model.Customer;

public interface CustomerDao {
	public void addCustomer(Customer customer);
	public List<Customer> listCustomers();
	public Customer getCustomer(int id);
	public void deleteCustomer(Customer customer);
}
