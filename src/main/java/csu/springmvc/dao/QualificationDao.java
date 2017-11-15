package csu.springmvc.dao;

import csu.springmvc.model.Qualification;

public interface QualificationDao {

  void addQualification(Qualification qualification);
  Qualification getQualification(int qualificationid);
}
