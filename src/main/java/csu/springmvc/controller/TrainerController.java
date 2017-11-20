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
public class TrainerController {
  @Autowired
  public TrainerService trainerService;

  @RequestMapping(value = "/createTrainer", method = RequestMethod.GET)
  public ModelAndView createTrainer(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("createTrainer");
    mav.addObject("trainer", new Trainer());
    
    return mav;
  }

  @RequestMapping(value = "/registerTrainer", method = RequestMethod.GET)
  public ModelAndView registerTrainer(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("registerTrainer");
    mav.addObject("trainer", new Trainer());
    
    return mav;
  }

  @RequestMapping(value = "/createTrainerProcess", method = RequestMethod.POST)
  public ModelAndView createTrainerProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("trainer") Trainer trainer) {

    trainerService.createTrainer(trainer);

    return new ModelAndView("success", "name", trainer.getName());
  }

  @RequestMapping(value = "/registerTrainerProcess", method = RequestMethod.POST)
  public ModelAndView registerTrainerProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("trainer") Trainer trainer) {

    trainerService.registerTrainer(trainer);

    return new ModelAndView("success", "name", trainer.getName());
  }
}
