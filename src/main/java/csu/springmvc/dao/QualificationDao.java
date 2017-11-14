package csu.springmvc.dao;

import csu.springmvc.model.Qualification;

public interface QualificationDao {

  void register(Qualification qualification);
  Qualification getQualification(int qualificationid);
}
