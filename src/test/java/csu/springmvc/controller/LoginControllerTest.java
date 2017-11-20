package csu.springmvc.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class LoginControllerTest {
  
  @Test
  public void testLogin() {
      LoginController loginController = new LoginController();
      ModelAndView mav = loginController.showLogin(null, null);
      Assert.assertEquals("login", mav.getViewName());
  }
}
