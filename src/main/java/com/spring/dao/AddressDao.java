package com.spring.dao;

import java.util.List;

import com.spring.model.Address;

public interface AddressDao {
	public void addAddress(Address address);
	public void updateAddress(Address address);
	public List<Address> listAddresses();
	public Address getAddress(int addressId);
	public void deleteAddress(Address address);
}
