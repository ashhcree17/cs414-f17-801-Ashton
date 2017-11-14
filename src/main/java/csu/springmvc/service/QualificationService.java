package csu.springmvc.service;

import csu.springmvc.model.Qualification;

public interface QualificationService {

  void register(Qualification qualification);
  Qualification getQualification(int qualificationid);
}
