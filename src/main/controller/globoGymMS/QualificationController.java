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

import globoGymMS.Qualification;
import globoGymMS.QualificationBean;
import globoGymMS.QualificationService;

@Controller
public class QualificationController {
	@Autowired
	private QualificationService qualificationService;
	
	private Qualification prepareModel(QualificationBean qualificationBean) {
		Qualification qualification = new Qualification();
		qualification.setQualId(qualificationBean.getQualId());
		qualification.setName(qualificationBean.getName());
		qualificationBean.setQualId(null);
		return qualification;
	}
	
	private List<QualificationBean> prepareListOfBean(List<Qualification> qualifications) {
		List<QualificationBean> beans = null;
		if (qualifications != null && !qualifications.isEmpty()) {
			beans = new ArrayList<QualificationBean>();
			QualificationBean bean = null;
			for (Qualification qualification : qualifications) {
				bean = new QualificationBean();
				bean.setQualId(qualification.getQualId());
				bean.setName(qualification.getName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private QualificationBean prepareQualificationBean(Qualification qualification) {
		QualificationBean bean = new QualificationBean();
		bean.setQualId(qualification.getQualId());
		bean.setName(qualification.getName());
		return bean;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveQualification(@ModelAttribute("command")QualificationBean qualificationBean,
			BindingResult result) {
		Qualification qualification = prepareModel(qualificationBean);
		qualificationService.addQualification(qualification);
		return new ModelAndView("addQualification");
	}
	
	@RequestMapping(value = "/qualifications", method = RequestMethod.GET) 
	public ModelAndView listQualifications() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("qualifications", prepareListOfBean(qualificationService.listQualifications()));
		return new ModelAndView("addQualification", model);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET) 
	public ModelAndView addQualification(@ModelAttribute("command")QualificationBean qualificationBean,
			BindingResult result){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("qualifications", prepareListOfBean(qualificationService.listQualifications()));
		return new ModelAndView("addQualification", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editQualification(@ModelAttribute("command")QualificationBean qualificationBean,
			BindingResult result) {
		qualificationService.deleteQualification(prepareModel(qualificationBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("qualification", null);
		model.put("qualifications", prepareListOfBean(qualificationService.listQualifications()));
		return new ModelAndView("addQualification", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteQualification(@ModelAttribute("command")QualificationBean qualificationBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("qualification", prepareQualificationBean(qualificationService.getQualification(qualificationBean.getQualId())));
		model.put("qualifications", prepareListOfBean(qualificationService.listQualifications()));
		return new ModelAndView("addQualification", model);
	}
}
