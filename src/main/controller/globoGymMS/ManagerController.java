package globoGymMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import globoGymMS.Manager;
import globoGymMS.ManagerBean;
import globoGymMS.ManagerService;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
	private Manager prepareModel(ManagerBean managerBean) {
		Manager manager = new Manager();
		manager.setId(managerBean.getId());
		manager.setUsername(managerBean.getUsername());
		manager.setPassword(managerBean.getPassword());
		manager.setName(managerBean.getName());
		manager.setLastName(managerBean.getLastName());
		managerBean.setId(null);
		return manager;
	}
	
	private List<ManagerBean> prepareListOfBean(List<Manager> managers) {
		List<ManagerBean> beans = null;
		if (managers != null && !managers.isEmpty()) {
			beans = new ArrayList<ManagerBean>();
			ManagerBean bean = null;
			for (Manager manager : managers) {
				bean = new ManagerBean();
				bean.setId(manager.getId());
				bean.setUsername(manager.getUsername());
				bean.setPassword(manager.getPassword());
				bean.setName(manager.getName());
				bean.setLastName(manager.getLastName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private ManagerBean prepareManagerBean(Manager manager) {
		ManagerBean bean = new ManagerBean();
		bean.setId(manager.getId());
		bean.setUsername(manager.getUsername());
		bean.setPassword(manager.getPassword());
		bean.setName(manager.getName());
		bean.setLastName(manager.getLastName());
		return bean;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveManager(@ModelAttribute("command")ManagerBean managerBean,
			BindingResult result) {
		Manager manager = prepareModel(managerBean);
		managerService.addManager(manager);
		return new ModelAndView("addManager");
	}
	
	@RequestMapping(value = "/managers", method = RequestMethod.GET) 
	public ModelAndView listManagers() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("managers", prepareListOfBean(managerService.listManagers()));
		return new ModelAndView("addManager", model);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET) 
	public ModelAndView addManager(@ModelAttribute("command")ManagerBean managerBean,
			BindingResult result){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("managers", prepareListOfBean(managerService.listManagers()));
		return new ModelAndView("addManager", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editManager(@ModelAttribute("command")ManagerBean managerBean,
			BindingResult result) {
		managerService.deleteManager(prepareModel(managerBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("manager", null);
		model.put("managers", prepareListOfBean(managerService.listManagers()));
		return new ModelAndView("addManager", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteManager(@ModelAttribute("command")ManagerBean managerBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("manager", prepareManagerBean(managerService.getManager(managerBean.getId())));
		model.put("managers", prepareListOfBean(managerService.listManagers()));
		return new ModelAndView("addEmployee", model);
	}
}
