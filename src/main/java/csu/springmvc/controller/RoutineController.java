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
public class RoutineController {
  @Autowired
  public RoutineService routineService;

  @RequestMapping(value = "/createRoutine", method = RequestMethod.GET)
  public ModelAndView createRoutine(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("createRoutine");
    mav.addObject("routine", new Routine());
    
    return mav;
  }

  @RequestMapping(value = "/createRoutineProcess", method = RequestMethod.POST)
  public ModelAndView createRoutineProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("routine") Routine routine) {

    routineService.createRoutine(routine);

    return new ModelAndView("success", "name", routine.getName());
  }
}
