package com.spring.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addAddress(Address address) {
		sessionFactory.getCurrentSession().saveOrUpdate(address);;
	}

	@Override
	public void updateAddress(Address address) {
		sessionFactory.getCurrentSession().update(address);
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Address> listAddresses() {
		return (List<Address>) sessionFactory.getCurrentSession()
				.createQuery("from Address").list();
	}
	
	@Override
	public Address getAddress(int addressId) {
		return (Address) sessionFactory.getCurrentSession().get(Address.class, addressId);
	}
	
	@Override
	public void deleteAddress(int addressId) {
//		sessionFactory.getCurrentSession().createQuery("DELETE FROM Address WHERE addressId = "+address.getAddressId());
		Address eq = (Address) sessionFactory.getCurrentSession().load(Address.class, new Integer(addressId));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
