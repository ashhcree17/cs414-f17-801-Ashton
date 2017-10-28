package main.service.globoGymMS;

import java.util.List;
import main.model.globoGymMS.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);
	public List<Customer> listCustomers();
	public Customer getCustomer(int id);
	public void deleteCustomer(Customer customer);
}
