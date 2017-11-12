package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.Customer;
import csu.springmvc.service.CustomerService;

@Controller
public class CustomerRegistrationController {
  @Autowired
  public CustomerService customerService;

  @RequestMapping(value = "/registerCustomer", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("registerCustomer");
    mav.addObject("customer", new Customer());
    
    return mav;
  }

  @RequestMapping(value = "/registerCustomerProcess", method = RequestMethod.POST)
  public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("customer") Customer customer) {

    customerService.register(customer);

    return new ModelAndView("welcome", "firstname", customer.getFirstname());
  }
}
