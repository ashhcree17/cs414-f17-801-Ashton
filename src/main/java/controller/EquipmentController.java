package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Equipment;
import service.EquipmentService;

@Controller
public class EquipmentController {
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired(required=true)
	@Qualifier(value="equipmentService")
	public void setPersonService(EquipmentService equipmentService){
		this.equipmentService = equipmentService;
	}
	
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String listInventory(Model model) {
		model.addAttribute("equipment", new Equipment());
		model.addAttribute("listInventory", this.equipmentService.listInventory());
		return "equipment";
	}
	
	//For add and update person both
	@RequestMapping(value= "/equipment/add", method = RequestMethod.POST)
	public String addEquipment(@ModelAttribute("equipment") Equipment equipment){
		if (equipment.getEquipmentId() == 0) {
			//new person, add it
			this.equipmentService.addEquipment(equipment);
		} else {
			//existing person, call update
			this.equipmentService.updateEquipment(equipment);
		}
		
		return "redirect:/inventory";
	}
	
	@RequestMapping("/delete/{equipmentId}")
    public String deleteEquipment(@ModelAttribute("equipment") Equipment equipment){
        this.equipmentService.deleteEquipment(equipment);
        return "redirect:/inventory";
    }
 
    @RequestMapping("/edit/{id}")
    public String editEquipment(@PathVariable("equipmentId") int equipmentId, Model model){
        model.addAttribute("person", this.equipmentService.getEquipment(equipmentId));
        model.addAttribute("listInventory", this.equipmentService.listInventory());
        return "equipment";
    }
}
