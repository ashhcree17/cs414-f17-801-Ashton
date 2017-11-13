package csu.springmvc.dao;

import csu.springmvc.model.Address;

public interface AddressDao {

  void register(Address address);
  Address getAddress(int addressid);
}
