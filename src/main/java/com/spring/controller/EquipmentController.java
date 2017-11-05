package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Equipment;
import com.spring.service.EquipmentService;

@Controller
public class EquipmentController {
	private EquipmentService equipmentService;
	
	@Autowired(required=true)
	@Qualifier(value="equipmentService")
	public void setEquipmentService(EquipmentService equipmentService){
		this.equipmentService = equipmentService;
	}
	
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String listInventory(Model model) {
		model.addAttribute("equipment", new Equipment());
		model.addAttribute("listInventory", this.equipmentService.listInventory());
		return "equipment";
	}
	
	@RequestMapping(value = "/equipment/{equipmentId}", method = RequestMethod.GET)
	public String getEquipment(@PathVariable("equipmentId") int equipmentId, ModelMap modelMap) {
		Equipment equipment = new Equipment();
		if (this.equipmentService.getEquipment(equipmentId) == null) {
			equipment.setEquipmentId(equipmentId);
			modelMap.addAttribute("equipment", equipment);
			this.equipmentService.getEquipment(equipmentId);
			return "equipment";			
		} else {
			return null;
		}
	}
	
	//For add and update person both
	@RequestMapping(value= "/equipment/add", method = RequestMethod.POST)
	public String addEquipment(@ModelAttribute("equipment") Equipment equipment,
			ModelMap modelMap){
		try {
			if (equipmentService.getEquipment(equipment.getEquipmentId()) != null) {
				// Denotes an existing Equipment - to be updated
				this.equipmentService.updateEquipment(equipment);
			} 
		}
		catch (NullPointerException e) {			
			// Denotes a new Equipment - to be added
			this.equipmentService.addEquipment(equipment);
		}
		
		modelMap.addAttribute("equipment", equipment);
		return "redirect:/equipments";
	}
	
	@RequestMapping("/delete/{equipmentId}")
    public String deleteEquipment(@PathVariable("equipmentId") int equipmentId){
        this.equipmentService.deleteEquipment(equipmentId);
        return "redirect:/inventory";
    }
 
    @RequestMapping("/edit/{equipmentId}")
    public String editEquipment(@PathVariable("equipmentId") int equipmentId, Model model){
        model.addAttribute("person", this.equipmentService.getEquipment(equipmentId));
        model.addAttribute("listInventory", this.equipmentService.listInventory());
        return "equipment";
    }
}
