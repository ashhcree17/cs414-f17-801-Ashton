package main.controller.globoGymMS;

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

import main.model.globoGymMS.Equipment;
import main.service.globoGymMS.EquipmentService;

@Controller
public class EquipmentController {
	@Autowired
	private EquipmentService equipmentService;
	
//	private Equipment prepareModel(EquipmentBean equipmentBean) {
//		Equipment equipment = new Equipment();
//		equipment.setEquipmentId(equipmentBean.getEquipmentId());
//		equipment.setName(equipmentBean.getName());
//		equipment.setPicture(equipmentBean.getPicture());
//		equipment.setQuantity(equipmentBean.getQuantity());
//		equipmentBean.setEquipmentId(null);
//		return equipment;
//	}
//	
//	private List<EquipmentBean> prepareListOfBean(List<Equipment> inventory) {
//		List<EquipmentBean> beans = null;
//		if (inventory != null && !inventory.isEmpty()) {
//			beans = new ArrayList<EquipmentBean>();
//			EquipmentBean bean = null;
//			for (Equipment equipment : inventory) {
//				bean = new EquipmentBean();
//				bean.setEquipmentId(equipment.getEquipmentId());
//				bean.setName(equipment.getName());
//				bean.setPicture(equipment.getPicture());
//				bean.setQuantity(equipment.getQuantity());
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}
//	
//	private EquipmentBean prepareEquipmentBean(Equipment equipment) {
//		EquipmentBean bean = new EquipmentBean();
//		bean.setEquipmentId(equipment.getEquipmentId());
//		bean.setName(equipment.getName());
//		bean.setPicture(equipment.getPicture());
//		bean.setQuantity(equipment.getQuantity());
//		return bean;
//	}
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ModelAndView saveEquipment(@ModelAttribute("command")EquipmentBean equipmentBean,
//			BindingResult result) {
//		Equipment equipment = prepareModel(equipmentBean);
//		equipmentService.addEquipment(equipment);
//		return new ModelAndView("addEquipment");
//	}
//	
//	@RequestMapping(value = "/inventory", method = RequestMethod.GET) 
//	public ModelAndView listEquipments() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("inventory", prepareListOfBean(equipmentService.listInventory()));
//		return new ModelAndView("addEquipment", model);
//	}
//	
//	@RequestMapping(value = "/add", method = RequestMethod.GET) 
//	public ModelAndView addEquipment(@ModelAttribute("command")EquipmentBean equipmentBean,
//			BindingResult result){
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("inventory", prepareListOfBean(equipmentService.listInventory()));
//		return new ModelAndView("addEquipment", model);
//	}
//	
//	@RequestMapping(value = "/index", method = RequestMethod.GET) 
//	public ModelAndView welcome() {
//		return new ModelAndView("index");
//	}
//	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public ModelAndView editEquipment(@ModelAttribute("command")EquipmentBean equipmentBean,
//			BindingResult result) {
//		equipmentService.deleteEquipment(prepareModel(equipmentBean));
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("equipment", null);
//		model.put("inventory", prepareListOfBean(equipmentService.listInventory()));
//		return new ModelAndView("addEquipment", model);
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public ModelAndView deleteEquipment(@ModelAttribute("command")EquipmentBean equipmentBean,
//			BindingResult result) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("equipment", prepareEquipmentBean(equipmentService.getEquipment(equipmentBean.getEquipmentId())));
//		model.put("inventory", prepareListOfBean(equipmentService.listInventory()));
//		return new ModelAndView("addEquipment", model);
//	}
}
