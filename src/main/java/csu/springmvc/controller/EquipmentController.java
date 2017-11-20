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
public class EquipmentController {
  @Autowired
  public EquipmentService equipmentService;

  @RequestMapping(value = "/createEquipment", method = RequestMethod.GET)
  public ModelAndView createEquipment(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("createEquipment");
    mav.addObject("equipment", new Equipment());
    
    return mav;
  }

  @RequestMapping(value = "/createEquipmentProcess", method = RequestMethod.POST)
  public ModelAndView createEquipmentProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("equipment") Equipment equipment) {

    equipmentService.createEquipment(equipment);

    return new ModelAndView("success", "name", equipment.getName());
  }
}
