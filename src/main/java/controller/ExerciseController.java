package controller;

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

import model.Exercise;
import service.ExerciseService;

@Controller
public class ExerciseController {
	@Autowired
	private ExerciseService exerciseService;
	
//	private Exercise prepareModel(ExerciseBean exerciseBean) {
//		Exercise exercise = new Exercise();
//		exercise.setExerciseId(exerciseBean.getExerciseId());
//		exercise.setName(exerciseBean.getName());
//		exercise.setDuration(exerciseBean.getDuration());
//		exercise.setNumberOfSets(exerciseBean.getNumberOfSets());
//		exercise.setRepsPerSet(exerciseBean.getRepsPerSet());
//		exerciseBean.setExerciseId(null);
//		return exercise;
//	}
//	
//	private List<ExerciseBean> prepareListOfBean(List<Exercise> exercises) {
//		List<ExerciseBean> beans = null;
//		if (exercises != null && !exercises.isEmpty()) {
//			beans = new ArrayList<ExerciseBean>();
//			ExerciseBean bean = null;
//			for (Exercise exercise : exercises) {
//				bean = new ExerciseBean();
//				bean.setExerciseId(exercise.getExerciseId());
//				bean.setName(exercise.getName());
//				bean.setDuration(exercise.getDuration());
//				bean.setNumberOfSets(exercise.getNumberOfSets());
//				bean.setRepsPerSet(exercise.getRepsPerSet());
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}
//	
//	private ExerciseBean prepareExerciseBean(Exercise exercise) {
//		ExerciseBean bean = new ExerciseBean();
//		bean.setExerciseId(exercise.getExerciseId());
//		bean.setName(exercise.getName());
//		bean.setDuration(exercise.getDuration());
//		bean.setNumberOfSets(exercise.getNumberOfSets());
//		bean.setRepsPerSet(exercise.getRepsPerSet());
//		return bean;
//	}
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ModelAndView saveExercise(@ModelAttribute("command")ExerciseBean exerciseBean,
//			BindingResult result) {
//		Exercise exercise = prepareModel(exerciseBean);
//		exerciseService.addExercise(exercise);
//		return new ModelAndView("addExercise");
//	}
//	
//	@RequestMapping(value = "/exercises", method = RequestMethod.GET) 
//	public ModelAndView listExercises() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("exercises", prepareListOfBean(exerciseService.listExercises()));
//		return new ModelAndView("addExercise", model);
//	}
//	
//	@RequestMapping(value = "/add", method = RequestMethod.GET) 
//	public ModelAndView addExercise(@ModelAttribute("command")ExerciseBean exerciseBean,
//			BindingResult result){
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("exercises", prepareListOfBean(exerciseService.listExercises()));
//		return new ModelAndView("addExercise", model);
//	}
//	
//	@RequestMapping(value = "/index", method = RequestMethod.GET) 
//	public ModelAndView welcome() {
//		return new ModelAndView("index");
//	}
//	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public ModelAndView editExercise(@ModelAttribute("command")ExerciseBean exerciseBean,
//			BindingResult result) {
//		exerciseService.deleteExercise(prepareModel(exerciseBean));
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("exercise", null);
//		model.put("exercises", prepareListOfBean(exerciseService.listExercises()));
//		return new ModelAndView("addExercise", model);
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public ModelAndView deleteExercise(@ModelAttribute("command")ExerciseBean exerciseBean,
//			BindingResult result) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("exercise", prepareExerciseBean(exerciseService.getExercise(exerciseBean.getExerciseId())));
//		model.put("exercises", prepareListOfBean(exerciseService.listExercises()));
//		return new ModelAndView("addExercise", model);
//	}
}
