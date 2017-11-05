package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import com.spring.model.Address;
import com.spring.service.AddressService;

@Controller
public class AddressController {
	private AddressService addressService;
	
	@Autowired(required = true)
	@Qualifier(value = "addressService")
	public void setAddressService(AddressService addressService){
		this.addressService = addressService;
	}
	
	@RequestMapping(value = "/addresses", method = RequestMethod.GET)
	public String listAddresses(ModelMap modelMap) {
		modelMap.addAttribute("address", new Address());
		modelMap.addAttribute("listAddresses", this.addressService.listAddresses());
		return "address";
	}
	
	@RequestMapping(value = "/address/{addressId}", method = RequestMethod.GET)
	public String getAddress(@PathVariable("addressId") int addressId, ModelMap modelMap) {
		Address address = this.addressService.getAddress(addressId);
		if (address != null) {
			address.setAddressId(addressId);
			modelMap.addAttribute("address", address);
			this.addressService.getAddress(addressId);
			return "address";			
		} else {
			return null;
		}
	}
	
	//For add and update person both
	@RequestMapping(value = "/address/add", method = RequestMethod.POST)
	public String addAddress(@ModelAttribute("address") Address address, ModelMap modelMap){
		try {
			if (addressService.getAddress(address.getAddressId()) != null) {
				// Denotes an existing Address - to be updated
				this.addressService.updateAddress(address);
			}
		} 
		catch (NullPointerException e) {
			// Denotes a new Address - to be added
			this.addressService.addAddress(address);
		}
		
		modelMap.addAttribute("address", address);
		return "redirect:/addresses";
	}
	
	@RequestMapping(value = "/delete/{addressId}", method = RequestMethod.DELETE)
    public String deleteAddress(@PathVariable("addressId") int addressId){
        this.addressService.deleteAddress(addressId);
        return "redirect:/addresses";
    }
 
    @RequestMapping(value = "/edit/{addressId}", method = RequestMethod.PUT)
    public String editAddress(@PathVariable("addressId") int addressId, ModelMap modelMap){
    		modelMap.addAttribute("address", this.addressService.getAddress(addressId));
    		modelMap.addAttribute("listAddresses", this.addressService.listAddresses());
        return "address";
    }
}
