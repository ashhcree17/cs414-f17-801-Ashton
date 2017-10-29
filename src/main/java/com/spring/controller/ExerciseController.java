package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Exercise;
import com.spring.service.ExerciseService;

@Controller
public class ExerciseController {
	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired(required=true)
	@Qualifier(value="exerciseService")
	public void setPersonService(ExerciseService exerciseService){
		this.exerciseService = exerciseService;
	}
	
	@RequestMapping(value = "/exercises", method = RequestMethod.GET)
	public String listExercises(Model model) {
		model.addAttribute("exercise", new Exercise());
		model.addAttribute("listExercises", this.exerciseService.listExercises());
		return "exercise";
	}
	
	//For add and update person both
	@RequestMapping(value= "/exercise/add", method = RequestMethod.POST)
	public String addExercise(@ModelAttribute("exercise") Exercise exercise){
		if (exercise.getExerciseId() == 0) {
			//new person, add it
			this.exerciseService.addExercise(exercise);
		} else {
			//existing person, call update
			this.exerciseService.updateExercise(exercise);
		}
		
		return "redirect:/exercises";
	}
	
	@RequestMapping("/delete/{exerciseId}")
    public String deleteExercise(@ModelAttribute("exercise") Exercise exercise){
        this.exerciseService.deleteExercise(exercise);
        return "redirect:/exercises";
    }
 
    @RequestMapping("/edit/{id}")
    public String editExercise(@PathVariable("exerciseId") int exerciseId, Model model){
        model.addAttribute("person", this.exerciseService.getExercise(exerciseId));
        model.addAttribute("listExercises", this.exerciseService.listExercises());
        return "exercise";
    }
}
