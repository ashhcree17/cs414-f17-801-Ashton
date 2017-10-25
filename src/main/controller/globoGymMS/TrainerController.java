package globoGymMS;

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

import globoGymMS.Trainer;
import globoGymMS.TrainerBean;
import globoGymMS.TrainerService;

@Controller
public class TrainerController {
	@Autowired
	private TrainerService trainerService;
	
	private Trainer prepareModel(TrainerBean trainerBean) {
		Trainer trainer = new Trainer();
		trainer.setId(trainerBean.getId());
		trainer.setUsername(trainerBean.getUsername());
		trainer.setPassword(trainerBean.getPassword());
		trainer.setName(trainerBean.getName());
		trainer.setLastName(trainerBean.getLastName());
		trainer.setAddress(trainerBean.getAddress());
		trainer.setPhoneNumber(trainerBean.getPhoneNumber());
		trainer.setEmail(trainerBean.getEmail());
		trainer.setInsurance(trainerBean.getInsurance());
		trainer.setWorkSchedule(trainerBean.getWorkSchedule());
		trainer.setQualifications(trainerBean.getQualifications());
		trainerBean.setId(null);
		return trainer;
	}
	
	private List<TrainerBean> prepareListOfBean(List<Trainer> trainers) {
		List<TrainerBean> beans = null;
		if (trainers != null && !trainers.isEmpty()) {
			beans = new ArrayList<TrainerBean>();
			TrainerBean bean = null;
			for (Trainer trainer : trainers) {
				bean = new TrainerBean();
				bean.setId(trainer.getId());
				bean.setUsername(trainer.getUsername());
				bean.setPassword(trainer.getPassword());
				bean.setName(trainer.getName());
				bean.setLastName(trainer.getLastName());
				bean.setAddress(trainer.getAddress());
				bean.setPhoneNumber(trainer.getPhoneNumber());
				bean.setEmail(trainer.getEmail());
				bean.setInsurance(trainer.getInsurance());
				bean.setWorkSchedule(trainer.getWorkSchedule());
				bean.setQualifications(trainer.getQualifications());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private TrainerBean prepareTrainerBean(Trainer trainer) {
		TrainerBean bean = new TrainerBean();
		bean.setId(trainer.getId());
		bean.setUsername(trainer.getUsername());
		bean.setPassword(trainer.getPassword());
		bean.setName(trainer.getName());
		bean.setLastName(trainer.getLastName());
		bean.setAddress(trainer.getAddress());
		bean.setPhoneNumber(trainer.getPhoneNumber());
		bean.setEmail(trainer.getEmail());
		bean.setInsurance(trainer.getInsurance());
		bean.setWorkSchedule(trainer.getWorkSchedule());
		bean.setQualifications(trainer.getQualifications());
		return bean;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveTrainer(@ModelAttribute("command")TrainerBean trainerBean,
			BindingResult result) {
		Trainer trainer = prepareModel(trainerBean);
		trainerService.addTrainer(trainer);
		return new ModelAndView("addTrainer");
	}
	
	@RequestMapping(value = "/trainers", method = RequestMethod.GET) 
	public ModelAndView listTrainers() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainers", prepareListOfBean(trainerService.listTrainers()));
		return new ModelAndView("addTrainer", model);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET) 
	public ModelAndView addTrainer(@ModelAttribute("command")TrainerBean trainerBean,
			BindingResult result){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainers", prepareListOfBean(trainerService.listTrainers()));
		return new ModelAndView("addTrainer", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editTrainer(@ModelAttribute("command")TrainerBean trainerBean,
			BindingResult result) {
		trainerService.deleteTrainer(prepareModel(trainerBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainer", null);
		model.put("trainers", prepareListOfBean(trainerService.listTrainers()));
		return new ModelAndView("addTrainer", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteTrainer(@ModelAttribute("command")TrainerBean trainerBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainer", prepareTrainerBean(trainerService.getTrainer(trainerBean.getId())));
		model.put("trainers", prepareListOfBean(trainerService.listTrainers()));
		return new ModelAndView("addTrainer", model);
	}
}
