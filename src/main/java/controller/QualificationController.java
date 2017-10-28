package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Qualification;
import service.QualificationService;

@Controller
public class QualificationController {
	@Autowired
	private QualificationService qualificationService;
	
	@Autowired(required=true)
	@Qualifier(value="qualificationService")
	public void setPersonService(QualificationService qualificationService){
		this.qualificationService = qualificationService;
	}
	
	@RequestMapping(value = "/qualifications", method = RequestMethod.GET)
	public String listQualifications(Model model) {
		model.addAttribute("qualification", new Qualification());
		model.addAttribute("listQualifications", this.qualificationService.listQualifications());
		return "qualification";
	}
	
	//For add and update person both
	@RequestMapping(value= "/qualification/add", method = RequestMethod.POST)
	public String addQualification(@ModelAttribute("qualification") Qualification qualification){
		if (qualification.getQualId() == 0) {
			//new person, add it
			this.qualificationService.addQualification(qualification);
		} else {
			//existing person, call update
			this.qualificationService.updateQualification(qualification);
		}
		
		return "redirect:/qualifications";
	}
	
	@RequestMapping("/delete/{qualificationId}")
    public String deleteQualification(@ModelAttribute("qualification") Qualification qualification){
        this.qualificationService.deleteQualification(qualification);
        return "redirect:/qualifications";
    }
 
    @RequestMapping("/edit/{id}")
    public String editQualification(@PathVariable("qualificationId") int qualificationId, Model model){
        model.addAttribute("person", this.qualificationService.getQualification(qualificationId));
        model.addAttribute("listQualifications", this.qualificationService.listQualifications());
        return "qualification";
    }
}
