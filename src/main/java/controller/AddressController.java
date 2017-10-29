package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Address;
import service.AddressService;

import org.springframework.ui.Model;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@Autowired(required=true)
	@Qualifier(value="addressService")
	public void setPersonService(AddressService addressService){
		this.addressService = addressService;
	}
	
	@RequestMapping(value = "/addresses", method = RequestMethod.GET)
	public String listAddresses(Model model) {
		model.addAttribute("address", new Address());
		model.addAttribute("listAddresses", this.addressService.listAddresses());
		return "address";
	}
	
	//For add and update person both
	@RequestMapping(value= "/address/add", method = RequestMethod.POST)
	public String addAddress(@ModelAttribute("address") Address address){
		if (address.getAddressId() == 0) {
			//new person, add it
			this.addressService.addAddress(address);
		} else {
			//existing person, call update
			this.addressService.updateAddress(address);
		}
		
		return "redirect:/addresses";
	}
	
	@RequestMapping("/delete/{addressId}")
    public String deleteAddress(@ModelAttribute("address") Address address){
        this.addressService.deleteAddress(address);
        return "redirect:/addresses";
    }
 
    @RequestMapping("/edit/{id}")
    public String editAddress(@PathVariable("addressId") int addressId, Model model){
        model.addAttribute("person", this.addressService.getAddress(addressId));
        model.addAttribute("listAddresses", this.addressService.listAddresses());
        return "address";
    }
}
