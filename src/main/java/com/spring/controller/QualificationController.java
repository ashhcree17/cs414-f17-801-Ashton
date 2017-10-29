package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Qualification;
import com.spring.service.QualificationService;

@Controller
public class QualificationController {
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
			// Denotes a new Qualification - to be added
			this.qualificationService.addQualification(qualification);
		} else {
			// Denotes an existing Qualification - to be updated
			this.qualificationService.updateQualification(qualification);
		}
		
		return "redirect:/qualifications";
	}
	
	@RequestMapping("/delete/{qualId}")
    public String deleteQualification(@PathVariable("qualId") int qualId){
        this.qualificationService.deleteQualification(qualId);
        return "redirect:/qualifications";
    }
 
    @RequestMapping("/edit/{qualId}")
    public String editQualification(@PathVariable("qualId") int qualId, Model model){
        model.addAttribute("qualification", this.qualificationService.getQualification(qualId));
        model.addAttribute("listQualifications", this.qualificationService.listQualifications());
        return "qualification";
    }
}
