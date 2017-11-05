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

import com.spring.model.Routine;
import com.spring.service.RoutineService;

@Controller
public class RoutineController {
	private RoutineService routineService;
	
	@Autowired(required=true)
	@Qualifier(value="routineService")
	public void setRoutineService(RoutineService routineService){
		this.routineService = routineService;
	}
	
	@RequestMapping(value = "/routines", method = RequestMethod.GET)
	public String listRoutines(Model model) {
		model.addAttribute("routine", new Routine());
		model.addAttribute("listRoutines", this.routineService.listRoutines());
		return "routine";
	}
	
	@RequestMapping(value = "/routine/{routineId}", method = RequestMethod.GET)
	public String getRoutine(@PathVariable("routineId") int routineId, ModelMap modelMap) {
		Routine routine = new Routine();
		if (this.routineService.getRoutine(routineId) == null) {
			routine.setRoutineId(routineId);
			modelMap.addAttribute("routine", routine);
			this.routineService.getRoutine(routineId);
			return "routine";			
		} else {
			return null;
		}
	}
	
	//For add and update person both
	@RequestMapping(value= "/routine/add", method = RequestMethod.POST)
	public String addRoutine(@ModelAttribute("routine") Routine routine,
			ModelMap modelMap){
		try {
			if (routineService.getRoutine(routine.getRoutineId()) != null) {
				// Denotes an existing Routine - to be updated
				this.routineService.updateRoutine(routine);
			} 
		}
		catch (NullPointerException e) {			
			// Denotes a new Routine - to be added
			this.routineService.addRoutine(routine);
		}
		
		modelMap.addAttribute("routine", routine);
		return "redirect:/routines";
	}
	
	@RequestMapping("/delete/{routineId}")
    public String deleteRoutine(@PathVariable("routineId") int routineId){
        this.routineService.deleteRoutine(routineId);
        return "redirect:/routines";
    }
 
    @RequestMapping("/edit/{routineId}")
    public String editRoutine(@PathVariable("routineId") int routineId, Model model){
        model.addAttribute("person", this.routineService.getRoutine(routineId));
        model.addAttribute("listRoutines", this.routineService.listRoutines());
        return "routine";
    }
}
