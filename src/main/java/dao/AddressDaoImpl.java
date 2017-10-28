package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Address;

@Repository("addressDao")
public class AddressDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addAddress(Address address) {
		sessionFactory.getCurrentSession().saveOrUpdate(address);
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Address> listAddresses() {
		return (List<Address>) sessionFactory.getCurrentSession()
				.createCriteria(Address.class).list();
	}
	
	public Address getAddress(int addressId) {
		return (Address) sessionFactory.getCurrentSession().get(Address.class, addressId);
	}
	
	public void deleteAddress(Address address) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Address WHERE addressId = "+address.getAddressId());
	}
}
