package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.Address;
import csu.springmvc.service.AddressService;

@Controller
public class AddressController {
  @Autowired
  public AddressService addressService;

  @RequestMapping(value = "/createAddress", method = RequestMethod.GET)
  public ModelAndView createAddress(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("createAddress");
    mav.addObject("address", new Address());
    
    return mav;
  }

  @RequestMapping(value = "/createAddressProcess", method = RequestMethod.POST)
  public ModelAndView createAddressProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("address") Address address) {
    
    addressService.createAddress(address);

    return new ModelAndView("successAddress", "street1", address.getStreet1());
  }
}
