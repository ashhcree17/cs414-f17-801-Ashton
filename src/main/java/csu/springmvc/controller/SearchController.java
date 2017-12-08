package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.service.AddressService;
import csu.springmvc.model.Address;

@Controller
public class SearchController {
  
    @Autowired    
    AddressService addressService;
    
    @RequestMapping(value="/searchAddress", method = RequestMethod.GET)
    public ModelAndView searchAddress(HttpServletRequest request, HttpServletResponse response) {
      
      ModelAndView mav = new ModelAndView("searchAddress");
      return mav;
    }
    
    @RequestMapping(value="/searchView", method = RequestMethod.POST)
    public ModelAndView searchView(HttpServletRequest request, HttpServletResponse response, 
        @RequestParam(value = "searchTerm", required = false) String pSearchTerm) {
      
      ModelAndView mav = new ModelAndView("searchAddress");
    
      mav.addObject("searchTerm", pSearchTerm);
      mav.addObject("searchResult", addressService.getAddress(Integer.parseInt(pSearchTerm)));      
    
      return new ModelAndView("searchView", "pSearchTerm", pSearchTerm);
    }
    
    @RequestMapping(value="/modifyView", method = RequestMethod.GET)
    public ModelAndView modifyView(HttpServletRequest request, HttpServletResponse response) {
      
      ModelAndView mav = new ModelAndView("modifyView");
      return mav;
    }
    
    @RequestMapping(value="/modifyView", method = RequestMethod.POST)
    public ModelAndView modifyView(HttpServletRequest request, HttpServletResponse response, 
        @RequestParam(value = "pSearchTerm", required = false) String pSearchTerm) {
    
      ModelAndView mav = new ModelAndView("modifyView");
      mav.addObject(addressService.getAddress(Integer.parseInt(pSearchTerm)));
      
      return mav;
    }
    
    @RequestMapping(value="/modifyViewProcess")
    public ModelAndView modifyViewProcess(HttpServletRequest request, HttpServletResponse response, 
        @ModelAttribute(value = "address") Address address) {
        ModelAndView mav = new ModelAndView("modifyView");
        mav.addObject(address);   

       return new ModelAndView("successModify", "address", address);
    }
}
