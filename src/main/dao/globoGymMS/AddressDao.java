package main.dao.globoGymMS;

import java.util.List;
import main.model.globoGymMS.Address;

public interface AddressDao {
	public void addAddress(Address address);
	public List<Address> listAddresses();
	public Address getAddress(int addressId);
	public void deleteAddress(Address address);
}
