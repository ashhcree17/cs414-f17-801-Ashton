package main.globoGymMS.service;

import java.util.List;

//import main.java.globoGymMS.model.Addres;
import main.globoGymMS.model.Address;

public interface AddressService {
	public void addAddress(Address address);
	public List<Address> listAddresses();
	public Address getAddress(int addressId);
	public void deleteAddress(Address address);
}
