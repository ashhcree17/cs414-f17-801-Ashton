package com.spring.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.spring.dao.CustomerDao;
import com.spring.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
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
	public Customer getCustomer(int customerId) {
		return customerDao.getCustomer(customerId);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);
	}
}
