package globoGymMS;

import java.util.List;
import globoGymMS.Address;

public interface AddressService {
	public void addAddress(Address address);
	public List<Address> listAddresses();
	public Address getAddress(int addressId);
	public void deleteAddress(Address address);
}
