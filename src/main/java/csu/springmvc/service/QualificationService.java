package csu.springmvc.service;

import csu.springmvc.model.Qualification;

public interface QualificationService {

  void createQualification(Qualification qualification);
  Qualification getQualification(int qualificationid);
}
