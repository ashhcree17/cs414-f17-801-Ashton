package csu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.TrainerDao;
import csu.springmvc.model.Login;
import csu.springmvc.model.Trainer;

public class TrainerServiceImpl implements TrainerService {

  @Autowired
  public TrainerDao trainerDao;

  public void registerTrainer(Trainer trainer) {
    trainerDao.registerTrainer(trainer);
  }
  
  public void createTrainer(Trainer trainer) {
    trainerDao.createTrainer(trainer);
  }

  public Trainer validateTrainer(Login login) {
    return trainerDao.validateTrainer(login);
  }

}
