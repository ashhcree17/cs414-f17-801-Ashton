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
	private TrainerService trainerService;
	
	@Autowired(required=true)
	@Qualifier(value="trainerService")
	public void setTrainerService(TrainerService trainerService){
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
			// Denotes a new Trainer - to be added
			this.trainerService.addTrainer(trainer);
		} else {
			// Denotes an existing Trainer - to be updated
			this.trainerService.updateTrainer(trainer);
		}
		
		return "redirect:/trainers";
	}
	
	@RequestMapping("/delete/{trainerId}")
    public String deleteTrainer(@PathVariable("trainerId") int trainerId){
        this.trainerService.deleteTrainer(trainerId);
        return "redirect:/trainers";
    }
 
    @RequestMapping("/edit/{trainerId}")
    public String editTrainer(@PathVariable("trainerId") int trainerId, Model model){
        model.addAttribute("person", this.trainerService.getTrainer(trainerId));
        model.addAttribute("listTrainers", this.trainerService.listTrainers());
        return "trainer";
    }
}
