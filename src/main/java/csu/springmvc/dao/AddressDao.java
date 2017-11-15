package csu.springmvc.dao;

import java.util.List;

import csu.springmvc.model.Address;

public interface AddressDao {

  void addAddress(Address address);
  void deleteAddress(int addressid);
  Address getAddress(int addressid);
  List<Address> listAddresses();
}
