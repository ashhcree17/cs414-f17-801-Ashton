package com.spring.service;

import java.util.List;

import com.spring.model.Qualification;

public interface QualificationService {
	public void addQualification(Qualification qualification);
	public void updateQualification(Qualification qualification);
	public List<Qualification> listQualifications();
	public Qualification getQualification(int qualId);
	public void deleteQualification(int qualId);
}
