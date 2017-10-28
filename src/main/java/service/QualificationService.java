package main.globoGymMS.service;

import java.util.List;

import main.java.globoGymMS.model.Qualification;

public interface QualificationService {
	public void addQualification(Qualification qualification);
	public List<Qualification> listQualifications();
	public Qualification getQualification(int qualificationId);
	public void deleteQualification(Qualification qualification);
}
