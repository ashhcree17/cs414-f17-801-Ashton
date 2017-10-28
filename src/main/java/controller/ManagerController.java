package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import model.Manager;
import service.ManagerService;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
	@Autowired(required=true)
	@Qualifier(value="managerService")
	public void setPersonService(ManagerService managerService){
		this.managerService = managerService;
	}
	
	@RequestMapping(value = "/managers", method = RequestMethod.GET)
	public String listManagers(Model model) {
		model.addAttribute("manager", new Manager());
		model.addAttribute("listManagers", this.managerService.listManagers());
		return "manager";
	}
	
	//For add and update person both
	@RequestMapping(value= "/manager/add", method = RequestMethod.POST)
	public String addManager(@ModelAttribute("manager") Manager manager){
		if (manager.getManagerId() == 0) {
			//new person, add it
			this.managerService.addManager(manager);
		} else {
			//existing person, call update
			this.managerService.updateManager(manager);
		}
		
		return "redirect:/managers";
	}
	
	@RequestMapping("/delete/{managerId}")
    public String deleteManager(@ModelAttribute("manager") Manager manager){
        this.managerService.deleteManager(manager);
        return "redirect:/managers";
    }
 
    @RequestMapping("/edit/{id}")
    public String editManager(@PathVariable("managerId") int managerId, Model model){
        model.addAttribute("person", this.managerService.getManager(managerId));
        model.addAttribute("listManagers", this.managerService.listManagers());
        return "manager";
    }
}
