package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import csu.springmvc.model.Trainer;
//import csu.springmvc.service.TrainerService;

@Controller
public class SearchController {
//  @Autowired
//  public SearchService searchService;

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public ModelAndView search(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("search");
    
    return mav;
  }

}
