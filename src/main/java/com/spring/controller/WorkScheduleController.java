package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.WorkSchedule;
import com.spring.service.WorkScheduleService;

@Controller
public class WorkScheduleController {
	private WorkScheduleService workScheduleService;
	
	@Autowired(required=true)
	@Qualifier(value="workScheduleService")
	public void setPersonService(WorkScheduleService workScheduleService){
		this.workScheduleService = workScheduleService;
	}
	
	@RequestMapping(value = "/workSchedules", method = RequestMethod.GET)
	public String listWorkSchedules(Model model) {
		model.addAttribute("workSchedule", new WorkSchedule());
		model.addAttribute("listWorkSchedules", this.workScheduleService.listWorkSchedules());
		return "workSchedule";
	}
	
	//For add and update person both
	@RequestMapping(value= "/workSchedule/add", method = RequestMethod.POST)
	public String addWorkSchedule(@ModelAttribute("workSchedule") WorkSchedule workSchedule){
		if (workSchedule.getWorkScheduleId() == 0) {
			// Denotes a new WorkSchedule - to be added
			this.workScheduleService.addWorkSchedule(workSchedule);
		} else {
			// Denotes an existing Work Schedule - to be updated
			this.workScheduleService.updateWorkSchedule(workSchedule);
		}
		
		return "redirect:/workSchedules";
	}
	
	@RequestMapping("/delete/{workScheduleId}")
    public String deleteWorkSchedule(@ModelAttribute("workSchedule") WorkSchedule workSchedule){
        this.workScheduleService.deleteWorkSchedule(workSchedule);
        return "redirect:/workSchedules";
    }
 
    @RequestMapping("/edit/{workScheduleId}")
    public String editWorkSchedule(@PathVariable("workScheduleId") int workScheduleId, Model model){
        model.addAttribute("workSchedule", this.workScheduleService.getWorkSchedule(workScheduleId));
        model.addAttribute("listWorkSchedules", this.workScheduleService.listWorkSchedules());
        return "workSchedule";
    }
}
