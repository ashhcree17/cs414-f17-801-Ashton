package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.Manager;
import csu.springmvc.service.ManagerService;

@Controller
public class ManagerRegistrationController {
  @Autowired
  public ManagerService managerService;

  @RequestMapping(value = "/registerManager", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("registerManager");
    mav.addObject("manager", new Manager());
    
    return mav;
  }

  @RequestMapping(value = "/registerManagerProcess", method = RequestMethod.POST)
  public ModelAndView addManager(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("manager") Manager manager) {

    managerService.register(manager);

    return new ModelAndView("welcome", "firstname", manager.getFirstname());
  }
}
