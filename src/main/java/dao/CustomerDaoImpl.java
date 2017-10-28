package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().persist(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Customer> listCustomers() {
		return (List<Customer>) sessionFactory.getCurrentSession()
				.createCriteria(Customer.class).list();
	}
	
	public Customer getCustomer(int id) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
	}
	
	public void deleteCustomer(Customer customer) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Customer WHERE customerId = "+customer.getCustomerId());
	}
}
