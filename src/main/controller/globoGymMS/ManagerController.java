package globoGymMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import globoGymMS.Manager;
import globoGymMS.ManagerService;

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
	
    // OLD OLD OLD //
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ModelAndView saveManager(@ModelAttribute("command")ManagerBean managerBean,
//			BindingResult result) {
//		Manager manager = prepareModel(managerBean);
//		managerService.addManager(manager);
//		return new ModelAndView("redirect:/add.html");
//	}
//	
//	@RequestMapping(value = "/managers", method = RequestMethod.GET) 
//	public ModelAndView listManagers() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("managers", prepareListOfBean(managerService.listManagers()));
//		return new ModelAndView("managersList", model);
//	}
//	
//	@RequestMapping(value = "/add", method = RequestMethod.GET) 
//	public ModelAndView addManager(@ModelAttribute("command")ManagerBean managerBean,
//			BindingResult result){
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("managers", prepareListOfBean(managerService.listManagers()));
//		return new ModelAndView("addManager", model);
//	}
//	
//	@RequestMapping(value = "/index", method = RequestMethod.GET) 
//	public ModelAndView welcome() {
//		return new ModelAndView("index");
//	}
//	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public ModelAndView deleteManager(@ModelAttribute("command")ManagerBean managerBean,
//			BindingResult result) {
//		managerService.deleteManager(prepareModel(managerBean));
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("manager", null);
//		model.put("managers", prepareListOfBean(managerService.listManagers()));
//		return new ModelAndView("addManager", model);
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public ModelAndView editManager(@ModelAttribute("command")ManagerBean managerBean,
//			BindingResult result) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("manager", prepareManagerBean(managerService.getManager(managerBean.getId())));
//		model.put("managers", prepareListOfBean(managerService.listManagers()));
//		return new ModelAndView("addManager", model);
//	}
}
