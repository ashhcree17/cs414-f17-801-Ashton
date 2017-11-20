package csu.springmvc.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class ManagerControllerTest {
  
  @Test
  public void testCreateManager() {
      ManagerController managerController = new ManagerController();
      ModelAndView mav = managerController.createManager(null, null);
      Assert.assertEquals("createManager", mav.getViewName());
  }
}
