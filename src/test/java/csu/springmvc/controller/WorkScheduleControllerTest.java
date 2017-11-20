package csu.springmvc.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class WorkScheduleControllerTest {
  
  @Test
  public void testCreateWorkSchedule() {
      WorkScheduleController workScheduleController = new WorkScheduleController();
      ModelAndView mav = workScheduleController.createWorkSchedule(null, null);
      Assert.assertEquals("createWorkSchedule", mav.getViewName());
  }
}
