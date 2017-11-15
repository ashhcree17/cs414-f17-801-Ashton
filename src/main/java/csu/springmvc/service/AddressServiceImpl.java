package csu.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.AddressDao;
import csu.springmvc.model.Address;

public class AddressServiceImpl implements AddressService {

  @Autowired
  public AddressDao addressDao;

  public void addAddress(Address address) {
    addressDao.addAddress(address);
  }
  
  public void deleteAddress(int addressid) {
    addressDao.deleteAddress(addressid);
  }

  public Address getAddress(int addressid) {
    return addressDao.getAddress(addressid);
  }

  public List<Address> listAddresses() {
    return addressDao.listAddresses();
  }
}
