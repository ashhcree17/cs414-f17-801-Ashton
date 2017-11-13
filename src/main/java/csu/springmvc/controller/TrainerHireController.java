package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.Trainer;
import csu.springmvc.service.TrainerService;

@Controller
public class TrainerHireController {
  @Autowired
  public TrainerService trainerService;

  @RequestMapping(value = "/hireTrainer", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("hireTrainer");
    mav.addObject("trainer", new Trainer());
    
    return mav;
  }

  @RequestMapping(value = "/hireTrainerProcess", method = RequestMethod.POST)
  public ModelAndView addTrainer(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("trainer") Trainer trainer) {

    trainerService.hire(trainer);

    return new ModelAndView("success", "firstname", trainer.getFirstname());
  }
}
