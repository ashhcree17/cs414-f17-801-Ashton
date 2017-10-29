package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Trainer;
import com.spring.service.TrainerService;

@Controller
public class TrainerController {
	@Autowired
	private TrainerService trainerService;
	
	@Autowired(required=true)
	@Qualifier(value="trainerService")
	public void setPersonService(TrainerService trainerService){
		this.trainerService = trainerService;
	}
	
	@RequestMapping(value = "/trainers", method = RequestMethod.GET)
	public String listTrainers(Model model) {
		model.addAttribute("trainer", new Trainer());
		model.addAttribute("listTrainers", this.trainerService.listTrainers());
		return "trainer";
	}
	
	//For add and update person both
	@RequestMapping(value= "/trainer/add", method = RequestMethod.POST)
	public String addTrainer(@ModelAttribute("trainer") Trainer trainer){
		if (trainer.getTrainerId() == 0) {
			//new person, add it
			this.trainerService.addTrainer(trainer);
		} else {
			//existing person, call update
			this.trainerService.updateTrainer(trainer);
		}
		
		return "redirect:/trainers";
	}
	
	@RequestMapping("/delete/{trainerId}")
    public String deleteTrainer(@ModelAttribute("trainer") Trainer trainer){
        this.trainerService.deleteTrainer(trainer);
        return "redirect:/trainers";
    }
 
    @RequestMapping("/edit/{id}")
    public String editTrainer(@PathVariable("trainerId") int trainerId, Model model){
        model.addAttribute("person", this.trainerService.getTrainer(trainerId));
        model.addAttribute("listTrainers", this.trainerService.listTrainers());
        return "trainer";
    }
}
