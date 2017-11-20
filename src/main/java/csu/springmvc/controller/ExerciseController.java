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
public class ExerciseController {
  @Autowired
  public ExerciseService exerciseService;

  @RequestMapping(value = "/createExerciseDuration", method = RequestMethod.GET)
  public ModelAndView showRegisterDuration(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("createExerciseDuration");
    mav.addObject("exercise", new Exercise());
    
    return mav;
  }
  
  @RequestMapping(value = "/createExerciseSets", method = RequestMethod.GET)
  public ModelAndView showRegisterSets(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("createExerciseSets");
    mav.addObject("exercise", new Exercise());
    
    return mav;
  }

  @RequestMapping(value = "/createExerciseDurationProcess", method = RequestMethod.POST)
  public ModelAndView addExerciseDuration(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("exercise") Exercise exercise) {

    exerciseService.createExerciseDuration(exercise);

    return new ModelAndView("success", "name", exercise.getName());
  }

  @RequestMapping(value = "/createExerciseSetsProcess", method = RequestMethod.POST)
  public ModelAndView addExerciseSets(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("exercise") Exercise exercise) {

    exerciseService.createExerciseSets(exercise);

    return new ModelAndView("success", "name", exercise.getName());
  }
}
