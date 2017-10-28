package main.globoGymMS.dao;

import java.util.List;

import main.globoGymMS.model.Qualification;

public interface QualificationDao {
	public void addQualification(Qualification qualification);
	public List<Qualification> listQualifications();
	public Qualification getQualification(int qualificationId);
	public void deleteQualification(Qualification qualification);
}
