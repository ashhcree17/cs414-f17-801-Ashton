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

import main.model.globoGymMS.Routine;
import main.service.globoGymMS.RoutineService;

@Controller
public class RoutineController {
	@Autowired
	private RoutineService routineService;
	
//	private Routine prepareModel(RoutineBean routineBean) {
//		Routine routine = new Routine();
//		routine.setRoutineId(routineBean.getRoutineId());
//		routine.setName(routineBean.getName());
//		routine.setExercises(routineBean.getExercises());
//		routineBean.setRoutineId(null);
//		return routine;
//	}
//	
//	private List<RoutineBean> prepareListOfBean(List<Routine> routines) {
//		List<RoutineBean> beans = null;
//		if (routines != null && !routines.isEmpty()) {
//			beans = new ArrayList<RoutineBean>();
//			RoutineBean bean = null;
//			for (Routine routine : routines) {
//				bean = new RoutineBean();
//				bean.setRoutineId(routine.getRoutineId());
//				bean.setName(routine.getName());
//				bean.setExercises(routine.getExercises());
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}
//	
//	private RoutineBean prepareRoutineBean(Routine routine) {
//		RoutineBean bean = new RoutineBean();
//		bean.setRoutineId(routine.getRoutineId());
//		bean.setName(routine.getName());
//		bean.setExercises(routine.getExercises());
//		return bean;
//	}
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ModelAndView saveRoutine(@ModelAttribute("command")RoutineBean routineBean,
//			BindingResult result) {
//		Routine routine = prepareModel(routineBean);
//		routineService.addRoutine(routine);
//		return new ModelAndView("addRoutine");
//	}
//	
//	@RequestMapping(value = "/routines", method = RequestMethod.GET) 
//	public ModelAndView listRoutines() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("routines", prepareListOfBean(routineService.listRoutines()));
//		return new ModelAndView("addRoutine", model);
//	}
//	
//	@RequestMapping(value = "/add", method = RequestMethod.GET) 
//	public ModelAndView addRoutine(@ModelAttribute("command")RoutineBean routineBean,
//			BindingResult result){
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("routines", prepareListOfBean(routineService.listRoutines()));
//		return new ModelAndView("addRoutine", model);
//	}
//	
//	@RequestMapping(value = "/index", method = RequestMethod.GET) 
//	public ModelAndView welcome() {
//		return new ModelAndView("index");
//	}
//	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public ModelAndView editRoutine(@ModelAttribute("command")RoutineBean routineBean,
//			BindingResult result) {
//		routineService.deleteRoutine(prepareModel(routineBean));
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("routine", null);
//		model.put("routines", prepareListOfBean(routineService.listRoutines()));
//		return new ModelAndView("addRoutine", model);
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public ModelAndView deleteRoutine(@ModelAttribute("command")RoutineBean routineBean,
//			BindingResult result) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("routine", prepareRoutineBean(routineService.getRoutine(routineBean.getRoutineId())));
//		model.put("routines", prepareListOfBean(routineService.listRoutines()));
//		return new ModelAndView("addRoutine", model);
//	}
}
