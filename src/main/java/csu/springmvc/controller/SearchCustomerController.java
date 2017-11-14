package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.Customer;
import csu.springmvc.service.CustomerService;

@Controller
public class SearchCustomerController {
  @Autowired
  public CustomerService customerService;

  @RequestMapping(value = "/searchCustomer", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("searchCustomer");
    mav.addObject("customer", new Customer());
    
    return mav;
  }

  @RequestMapping(value = "/searchCustomerProcess", method = RequestMethod.GET)
  public ModelAndView addQualification(HttpServletRequest request, HttpServletResponse response,
      @RequestParam("customerid") int customerid) {

    customerService.getCustomer(customerid);

//    return new ModelAndView("modifyCustomer", "name", customer.getName());
    return new ModelAndView("modifyCustomer", "customer", 
        customerService.getCustomer(customerid));
  }
}
