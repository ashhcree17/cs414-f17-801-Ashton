package globoGymMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import globoGymMS.Customer;
import globoGymMS.CustomerDao;

@Service("customerService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class CustomerServiceImpl {
	@Autowired
	private CustomerDao customerDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public List<Customer> listCustomers() {
		return customerDao.listCustomers();
	}
	
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}
	
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}
}
