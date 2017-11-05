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

import com.spring.model.Exercise;
import com.spring.service.ExerciseService;

@Controller
public class ExerciseController {
	private ExerciseService exerciseService;
	
	@Autowired(required=true)
	@Qualifier(value="exerciseService")
	public void setExerciseService(ExerciseService exerciseService){
		this.exerciseService = exerciseService;
	}
	
	@RequestMapping(value = "/exercises", method = RequestMethod.GET)
	public String listExercises(Model model) {
		model.addAttribute("exercise", new Exercise());
		model.addAttribute("listExercises", this.exerciseService.listExercises());
		return "exercise";
	}
	
	@RequestMapping(value = "/exercise/{exerciseId}", method = RequestMethod.GET)
	public String getExercise(@PathVariable("exerciseId") int exerciseId, ModelMap modelMap) {
		Exercise exercise = this.exerciseService.getExercise(exerciseId);
		if (exercise != null) {
			exercise.setExerciseId(exerciseId);
			modelMap.addAttribute("exercise", exercise);
			this.exerciseService.getExercise(exerciseId);
			return "exercise";			
		} else {
			return null;
		}
	}
	
	//For add and update person both
	@RequestMapping(value= "/exercise/add", method = RequestMethod.POST)
	public String addExercise(@ModelAttribute("exercise") Exercise exercise,
			ModelMap modelMap){
		try {
			if (exerciseService.getExercise(exercise.getExerciseId()) != null) {
				// Denotes an existing Exercise - to be updated
				this.exerciseService.updateExercise(exercise);
			} 
		}
		catch (NullPointerException e) {			
			// Denotes a new Exercise - to be added
			this.exerciseService.addExercise(exercise);
		}
		
		modelMap.addAttribute("exercise", exercise);
		return "redirect:/exercises";
	}
	
	@RequestMapping("/delete/{exerciseId}")
    public String deleteExercise(@PathVariable("exerciseId") int exerciseId){
        this.exerciseService.deleteExercise(exerciseId);
        return "redirect:/exercises";
    }
 
    @RequestMapping("/edit/{exerciseId}")
    public String editExercise(@PathVariable("exerciseId") int exerciseId, Model model){
        model.addAttribute("exercise", this.exerciseService.getExercise(exerciseId));
        model.addAttribute("listExercises", this.exerciseService.listExercises());
        return "exercise";
    }
}
