package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.Routine;
import csu.springmvc.service.RoutineService;

@Controller
public class RoutineRegistrationController {
  @Autowired
  public RoutineService routineService;

  @RequestMapping(value = "/registerRoutine", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("registerRoutine");
    mav.addObject("routine", new Routine());
    
    return mav;
  }

  @RequestMapping(value = "/registerRoutineProcess", method = RequestMethod.POST)
  public ModelAndView addRoutine(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("routine") Routine routine) {

    routineService.register(routine);

    return new ModelAndView("success", "name", routine.getName());
  }
}
