package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.Exercise;
import csu.springmvc.service.ExerciseService;

@Controller
public class ExerciseRegistrationController {
  @Autowired
  public ExerciseService exerciseService;

  @RequestMapping(value = "/registerExerciseDuration", method = RequestMethod.GET)
  public ModelAndView showRegisterDuration(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("registerExerciseDuration");
    mav.addObject("exercise", new Exercise());
    
    return mav;
  }
  
  @RequestMapping(value = "/registerExerciseSets", method = RequestMethod.GET)
  public ModelAndView showRegisterSets(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("registerExerciseSets");
    mav.addObject("exercise", new Exercise());
    
    return mav;
  }

  @RequestMapping(value = "/registerExerciseDurationProcess", method = RequestMethod.POST)
  public ModelAndView addExerciseDuration(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("exercise") Exercise exercise) {

    exerciseService.registerDuration(exercise);

    return new ModelAndView("success", "name", exercise.getName());
  }

  @RequestMapping(value = "/registerExerciseSetsProcess", method = RequestMethod.POST)
  public ModelAndView addExerciseSets(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("exercise") Exercise exercise) {

    exerciseService.registerSets(exercise);

    return new ModelAndView("success", "name", exercise.getName());
  }
}
