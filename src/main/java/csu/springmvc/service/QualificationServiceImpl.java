package csu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.QualificationDao;
import csu.springmvc.model.Qualification;

public class QualificationServiceImpl implements QualificationService {

  @Autowired
  public QualificationDao qualificationDao;

  public void register(Qualification qualification) {
    qualificationDao.addQualification(qualification);
  }

  public Qualification getQualification(int qualificationid) {
    return qualificationDao.getQualification(qualificationid);
  }
}
