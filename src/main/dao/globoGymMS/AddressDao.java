package globoGymMS;

import java.util.List;

public interface AddressDao {
	public void addAddress(Address address);
	public List<Address> listAddresses();
	public Address getAddress(int addressId);
	public void deleteAddress(Address address);
}
