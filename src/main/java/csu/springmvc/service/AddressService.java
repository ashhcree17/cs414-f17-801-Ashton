package csu.springmvc.service;

import java.util.List;

import csu.springmvc.model.Address;

public interface AddressService {

  void addAddress(Address address);
  void deleteAddress(int addressid);
  Address getAddress(int addressid);
  List<Address> listAddresses();
}
