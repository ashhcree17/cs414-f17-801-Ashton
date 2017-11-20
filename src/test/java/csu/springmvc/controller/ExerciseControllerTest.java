package csu.springmvc.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class ExerciseControllerTest {
  
  @Test
  public void testCreateExerciseDuration() {
      ExerciseController exerciseController = new ExerciseController();
      ModelAndView mav = exerciseController.createExerciseDuration(null, null);
      Assert.assertEquals("createExerciseDuration", mav.getViewName());
  }
  
  @Test
  public void testCreateExerciseSets() {
      ExerciseController exerciseController = new ExerciseController();
      ModelAndView mav = exerciseController.createExerciseSets(null, null);
      Assert.assertEquals("createExerciseSets", mav.getViewName());
  }
}
