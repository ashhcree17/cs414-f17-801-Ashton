package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Routine;
import service.RoutineService;

@Controller
public class RoutineController {
	@Autowired
	private RoutineService routineService;
	
	@Autowired(required=true)
	@Qualifier(value="routineService")
	public void setPersonService(RoutineService routineService){
		this.routineService = routineService;
	}
	
	@RequestMapping(value = "/routines", method = RequestMethod.GET)
	public String listRoutines(Model model) {
		model.addAttribute("routine", new Routine());
		model.addAttribute("listRoutines", this.routineService.listRoutines());
		return "routine";
	}
	
	//For add and update person both
	@RequestMapping(value= "/routine/add", method = RequestMethod.POST)
	public String addRoutine(@ModelAttribute("routine") Routine routine){
		if (routine.getRoutineId() == 0) {
			//new person, add it
			this.routineService.addRoutine(routine);
		} else {
			//existing person, call update
			this.routineService.updateRoutine(routine);
		}
		
		return "redirect:/routines";
	}
	
	@RequestMapping("/delete/{routineId}")
    public String deleteRoutine(@ModelAttribute("routine") Routine routine){
        this.routineService.deleteRoutine(routine);
        return "redirect:/routines";
    }
 
    @RequestMapping("/edit/{id}")
    public String editRoutine(@PathVariable("routineId") int routineId, Model model){
        model.addAttribute("person", this.routineService.getRoutine(routineId));
        model.addAttribute("listRoutines", this.routineService.listRoutines());
        return "routine";
    }
}
