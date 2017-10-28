package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import dao.CustomerDao;
import model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}
	
	@Override
	@Transactional
	public List<Customer> listCustomers() {
		return customerDao.listCustomers();
	}
	
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}
}
