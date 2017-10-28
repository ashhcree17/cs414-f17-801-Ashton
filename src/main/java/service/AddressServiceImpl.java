package main.globoGymMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import main.java.globoGymMS.dao.AddressDao;
import main.java.globoGymMS.model.Address;

@Service("addressService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class AddressServiceImpl {
	@Autowired
	private AddressDao addressDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAddress(Address address) {
		addressDao.addAddress(address);
	}
	
	public List<Address> listAddresses() {
		return addressDao.listAddresses();
	}
	
	public Address getAddress(int addressId) {
		return addressDao.getAddress(addressId);
	}
	
	public void deleteAddress(Address address) {
		addressDao.deleteAddress(address);
	}
}
