package csu.springmvc.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class RoutineControllerTest {
  
  @Test
  public void testCreateRoutine() {
      RoutineController routineController = new RoutineController();
      ModelAndView mav = routineController.createRoutine(null, null);
      Assert.assertEquals("createRoutine", mav.getViewName());
  }
}
