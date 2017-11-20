package csu.springmvc.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class TrainerControllerTest {
  
  @Test
  public void testCreateTrainer() {
      TrainerController trainerController = new TrainerController();
      ModelAndView mav = trainerController.createTrainer(null, null);
      Assert.assertEquals("createTrainer", mav.getViewName());
  }
}
