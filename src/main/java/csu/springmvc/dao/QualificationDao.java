package csu.springmvc.dao;

import csu.springmvc.model.Qualification;

public interface QualificationDao {

  void createQualification(Qualification qualification);
  Qualification getQualification(int qualificationid);
}
