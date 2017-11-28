package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public ModelAndView search(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("search");
    
    return mav;
  }

//  @RequestMapping(value = "/searchProcess", method = RequestMethod.GET)
//  public String searchProcessByAddress(@PathVariable int addressid,
//      Model model) {
//    model.addAttribute("search", addressService.getAddress(addressid));
//    return "addressList";
//  }
}
