package main.globoGymMS.controller;

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

import main.globoGymMS.model.WorkSchedule;
import main.globoGymMS.service.WorkScheduleService;

@Controller
public class WorkScheduleController {
	@Autowired
	private WorkScheduleService workScheduleService;
	
//	private WorkSchedule prepareModel(WorkScheduleBean workScheduleBean) {
//		WorkSchedule workSchedule = new WorkSchedule();
//		workSchedule.setWorkScheduleId(workScheduleBean.getWorkScheduleId());
//		workSchedule.setDay(workScheduleBean.getDay());
//		workSchedule.setStartTime(workScheduleBean.getStartTime());
//		workSchedule.setEndTime(workScheduleBean.getEndTime());
//		workScheduleBean.setWorkScheduleId(null);
//		return workSchedule;
//	}
//	
//	private List<WorkScheduleBean> prepareListOfBean(List<WorkSchedule> workSchedules) {
//		List<WorkScheduleBean> beans = null;
//		if (workSchedules != null && !workSchedules.isEmpty()) {
//			beans = new ArrayList<WorkScheduleBean>();
//			WorkScheduleBean bean = null;
//			for (WorkSchedule workSchedule : workSchedules) {
//				bean = new WorkScheduleBean();
//				bean.setWorkScheduleId(workSchedule.getWorkScheduleId());
//				bean.setDay(workSchedule.getDay());
//				bean.setStartTime(workSchedule.getStartTime());
//				bean.setEndTime(workSchedule.getEndTime());
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}
//	
//	private WorkScheduleBean prepareWorkScheduleBean(WorkSchedule workSchedule) {
//		WorkScheduleBean bean = new WorkScheduleBean();
//		bean.setWorkScheduleId(workSchedule.getWorkScheduleId());
//		bean.setDay(workSchedule.getDay());
//		bean.setStartTime(workSchedule.getStartTime());
//		bean.setEndTime(workSchedule.getEndTime());
//		return bean;
//	}
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ModelAndView saveWorkSchedule(@ModelAttribute("command")WorkScheduleBean workScheduleBean,
//			BindingResult result) {
//		WorkSchedule workSchedule = prepareModel(workScheduleBean);
//		workScheduleService.addWorkSchedule(workSchedule);
//		return new ModelAndView("addWorkSchedule");
//	}
//	
//	@RequestMapping(value = "/workSchedules", method = RequestMethod.GET) 
//	public ModelAndView listWorkSchedules() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("workSchedules", prepareListOfBean(workScheduleService.listWorkSchedules()));
//		return new ModelAndView("addWorkSchedule", model);
//	}
//	
//	@RequestMapping(value = "/add", method = RequestMethod.GET) 
//	public ModelAndView addWorkSchedule(@ModelAttribute("command")WorkScheduleBean workScheduleBean,
//			BindingResult result){
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("workSchedules", prepareListOfBean(workScheduleService.listWorkSchedules()));
//		return new ModelAndView("addWorkSchedule", model);
//	}
//	
//	@RequestMapping(value = "/index", method = RequestMethod.GET) 
//	public ModelAndView welcome() {
//		return new ModelAndView("index");
//	}
//	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public ModelAndView editWorkSchedule(@ModelAttribute("command")WorkScheduleBean workScheduleBean,
//			BindingResult result) {
//		workScheduleService.deleteWorkSchedule(prepareModel(workScheduleBean));
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("workSchedule", null);
//		model.put("workSchedules", prepareListOfBean(workScheduleService.listWorkSchedules()));
//		return new ModelAndView("addWorkSchedule", model);
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public ModelAndView deleteWorkSchedule(@ModelAttribute("command")WorkScheduleBean workScheduleBean,
//			BindingResult result) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("workSchedule", prepareWorkScheduleBean(workScheduleService.getWorkSchedule(workScheduleBean.getWorkScheduleId())));
//		model.put("workSchedules", prepareListOfBean(workScheduleService.listWorkSchedules()));
//		return new ModelAndView("addWorkSchedule", model);
//	}
}
