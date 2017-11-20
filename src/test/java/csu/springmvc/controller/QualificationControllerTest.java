package csu.springmvc.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class QualificationControllerTest {
  
  @Test
  public void testCreateQualification() {
      QualificationController qualificationController = new QualificationController();
      ModelAndView mav = qualificationController.createQualification(null, null);
      Assert.assertEquals("createQualification", mav.getViewName());
  }
}
