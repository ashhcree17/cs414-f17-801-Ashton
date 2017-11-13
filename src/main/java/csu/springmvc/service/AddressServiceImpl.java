package csu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.AddressDao;
import csu.springmvc.model.Address;

public class AddressServiceImpl implements AddressService {

  @Autowired
  public AddressDao addressDao;

  public void register(Address address) {
    addressDao.register(address);
  }

  public Address getAddress(int addressid) {
    return addressDao.getAddress(addressid);
  }
}
