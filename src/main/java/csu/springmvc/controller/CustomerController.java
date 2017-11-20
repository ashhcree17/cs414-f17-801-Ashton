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
public class CustomerController {
  @Autowired
  public CustomerService customerService;

  @RequestMapping(value = "/createCustomer", method = RequestMethod.GET)
  public ModelAndView createCustomer(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("createCustomer");
    mav.addObject("customer", new Customer());
    
    return mav;
  }

  @RequestMapping(value = "/modifyCustomer", method = RequestMethod.GET)
  public ModelAndView modifyCustomer(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("modifyCustomer");
    mav.addObject("customer", new Customer());
    
    return mav;
  }

  @RequestMapping(value = "/createCustomerProcess", method = RequestMethod.POST)
  public ModelAndView createCustomerProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("customer") Customer customer) {

    customerService.createCustomer(customer);

    return new ModelAndView("success", "name", customer.getName());
  }

  @RequestMapping(value = "/modifyCustomerProcess", method = RequestMethod.POST)
  public ModelAndView modifyCustomerProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("customer") Customer customer) {

    customerService.createCustomer(customer);

    return new ModelAndView("success", "name", customer.getName());
  }
}
