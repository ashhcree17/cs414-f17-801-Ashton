package globoGymMS;

import java.util.List;

public interface CustomerDao {
	public void addCustomer(Customer customer);
	public List<Customer> listCustomers();
	public Customer getCustomer(int id);
	public void deleteCustomer(Customer customer);
}
