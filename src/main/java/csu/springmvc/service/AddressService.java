package csu.springmvc.service;

import csu.springmvc.model.Address;

public interface AddressService {

  void register(Address address);
  Address getAddress(int addressid);
}
