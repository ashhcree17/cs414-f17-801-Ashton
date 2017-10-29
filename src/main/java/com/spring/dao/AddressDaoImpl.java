package com.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addAddress(Address address) {
		sessionFactory.getCurrentSession().persist(address);
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
	public void deleteAddress(Address address) {
//		sessionFactory.getCurrentSession().createQuery("DELETE FROM Address WHERE addressId = "+address.getAddressId());
		Address eq = (Address) sessionFactory.getCurrentSession().load(Address.class, new Integer(address.getAddressId()));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
