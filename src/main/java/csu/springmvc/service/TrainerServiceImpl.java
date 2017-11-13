package csu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.TrainerDao;
import csu.springmvc.model.Login;
import csu.springmvc.model.Trainer;

public class TrainerServiceImpl implements TrainerService {

  @Autowired
  public TrainerDao trainerDao;

  public void register(Trainer trainer) {
    trainerDao.register(trainer);
  }
  
  public void hire(Trainer trainer) {
    trainerDao.hire(trainer);
  }

  public Trainer validateTrainer(Login login) {
    return trainerDao.validateTrainer(login);
  }

}
