package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.spring.model.Manager;
import com.spring.service.ManagerService;

@Controller
public class ManagerController {
	private ManagerService managerService;
	
	@Autowired(required=true)
	@Qualifier(value="managerService")
	public void setManagerService(ManagerService managerService){
		this.managerService = managerService;
	}
	
	@RequestMapping(value = "/managers", method = RequestMethod.GET)
	public String listManagers(Model model) {
		model.addAttribute("manager", new Manager());
		model.addAttribute("listManagers", this.managerService.listManagers());
		return "manager";
	}
	
	@RequestMapping(value = "/manager/{managerId}", method = RequestMethod.GET)
	public String getManager(@PathVariable("managerId") int managerId, ModelMap modelMap) {
		Manager manager = this.managerService.getManager(managerId);
		if (manager != null) {
			manager.setManagerId(managerId);
			modelMap.addAttribute("manager", manager);
			this.managerService.getManager(managerId);
			return "manager";			
		} else {
			return null;
		}
	}
	
	// For add and update person both
	@RequestMapping(value= "/manager/add", method = RequestMethod.POST)
	public String addManager(@ModelAttribute("manager") Manager manager,
			ModelMap modelMap){
		try {
			if (managerService.getManager(manager.getManagerId()) != null) {
				// Denotes an existing Manager - to be updated
				this.managerService.updateManager(manager);
			} 
		}
		catch (NullPointerException e) {			
			// Denotes a new Manager - to be added
			this.managerService.addManager(manager);
		}
		
		modelMap.addAttribute("manager", manager);
		return "redirect:/managers";
	}
	
	@RequestMapping("/delete/{managerId}")
    public String deleteManager(@PathVariable("managerId") int managerId){
        this.managerService.deleteManager(managerId);
        return "redirect:/managers";
    }
 
    @RequestMapping("/edit/{managerId}")
    public String editManager(@PathVariable("managerId") int managerId, Model model){
        model.addAttribute("person", this.managerService.getManager(managerId));
        model.addAttribute("listManagers", this.managerService.listManagers());
        return "manager";
    }
}
