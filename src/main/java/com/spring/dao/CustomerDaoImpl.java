package com.spring.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().persist(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Customer> listCustomers() {
		return (List<Customer>) sessionFactory.getCurrentSession()
				.createQuery("from Customer").list();
	}
	
	@Override
	public Customer getCustomer(int customerId) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}
	
	@Override
	public void deleteCustomer(int customerId) {
		Customer eq = (Customer) sessionFactory.getCurrentSession().load(Customer.class, new Integer(customerId));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
