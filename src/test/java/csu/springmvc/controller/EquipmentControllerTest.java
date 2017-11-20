package csu.springmvc.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class EquipmentControllerTest {
  
  @Test
  public void testCreateEquipmentDuration() {
      EquipmentController equipmentController = new EquipmentController();
      ModelAndView mav = equipmentController.createEquipment(null, null);
      Assert.assertEquals("createEquipment", mav.getViewName());
  }
}
