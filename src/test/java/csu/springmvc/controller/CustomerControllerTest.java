package csu.springmvc.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class CustomerControllerTest {
  
  @Test
  public void testCreateCustomer() {
      CustomerController customerController = new CustomerController();
      ModelAndView mav = customerController.createCustomer(null, null);
      Assert.assertEquals("createCustomer", mav.getViewName());
  }
}
