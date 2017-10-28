package service;

import java.util.List;

import model.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public List<Customer> listCustomers();
	public Customer getCustomer(int id);
	public void deleteCustomer(Customer customer);
}
