package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.Qualification;
import csu.springmvc.service.QualificationService;

@Controller
public class QualificationController {
  @Autowired
  public QualificationService qualificationService;

  @RequestMapping(value = "/createQualification", method = RequestMethod.GET)
  public ModelAndView createQualification(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("createQualification");
    mav.addObject("qualification", new Qualification());
    
    return mav;
  }

  @RequestMapping(value = "/createQualificationProcess", method = RequestMethod.POST)
  public ModelAndView createQualificationProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("qualification") Qualification qualification) {

    qualificationService.createQualification(qualification);

    return new ModelAndView("success", "name", qualification.getName());
  }
}
