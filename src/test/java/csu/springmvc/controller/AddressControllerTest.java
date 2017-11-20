package csu.springmvc.controller;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.controller.AddressController;

public class AddressControllerTest {
  
  @Test
  public void testCreateAddress() {
      AddressController addressController = new AddressController();
      ModelAndView mav = addressController.createAddress(null, null);
      Assert.assertEquals("createAddress", mav.getViewName());
  }
}
