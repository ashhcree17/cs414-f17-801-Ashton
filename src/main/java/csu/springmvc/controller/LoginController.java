package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.Login;
import csu.springmvc.model.Manager;
import csu.springmvc.service.ManagerService;
import csu.springmvc.model.Trainer;
import csu.springmvc.service.TrainerService;

@Controller
public class LoginController {

  @Autowired
  ManagerService managerService;
  
  @Autowired
  TrainerService trainerService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());

    return mav;
  }

  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("login") Login login) {
    ModelAndView mav = null;

    Manager manager = managerService.validateManager(login);
    Trainer trainer = trainerService.validateTrainer(login);

    if (null != manager) {
      mav = new ModelAndView("welcomeManager");
      mav.addObject("firstname", manager.getFirstname());
    } else if (null != trainer) {
      mav = new ModelAndView("welcomeTrainer");
      mav.addObject("firstname", trainer.getFirstname());
    } else {  
      mav = new ModelAndView("login");
      mav.addObject("message", "Username or Password is incorrect!");
    }

    return mav;
  }

}
