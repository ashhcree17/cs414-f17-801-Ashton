package com.spring.dao;

import java.util.List;

import com.spring.model.Qualification;

public interface QualificationDao {
	public void addQualification(Qualification qualification);
	public void updateQualification(Qualification qualification);	
	public List<Qualification> listQualifications();
	public Qualification getQualification(int qualId);
	public void deleteQualification(int qualId);
}
