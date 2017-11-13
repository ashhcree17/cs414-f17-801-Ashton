package csu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.model.Equipment;
import csu.springmvc.service.EquipmentService;

@Controller
public class EquipmentRegistrationController {
  @Autowired
  public EquipmentService equipmentService;

  @RequestMapping(value = "/registerEquipment", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("registerEquipment");
    mav.addObject("equipment", new Equipment());
    
    return mav;
  }

  @RequestMapping(value = "/registerEquipmentProcess", method = RequestMethod.POST)
  public ModelAndView addEquipment(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("equipment") Equipment equipment) {

    equipmentService.register(equipment);

    return new ModelAndView("success", "name", equipment.getName());
  }
}
