package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.WorkSchedule;
import csu.springmvc.service.WorkScheduleService;

@Controller
public class WorkScheduleRegistrationController {
  @Autowired
  public WorkScheduleService workScheduleService;

  @RequestMapping(value = "/registerWorkSchedule", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("registerWorkSchedule");
    mav.addObject("workSchedule", new WorkSchedule());
    
    return mav;
  }

  @RequestMapping(value = "/registerWorkScheduleProcess", method = RequestMethod.POST)
  public ModelAndView addWorkSchedule(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("workSchedule") WorkSchedule workSchedule) {

    workScheduleService.register(workSchedule);

    return new ModelAndView("successWorkSchedule", "day", workSchedule.getDay());
  }
}
