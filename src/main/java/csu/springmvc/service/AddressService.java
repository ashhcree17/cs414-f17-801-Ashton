package csu.springmvc.service;

import csu.springmvc.model.Address;

public interface AddressService {

  void addAddress(Address address);
  Address getAddress(int addressid);
}
