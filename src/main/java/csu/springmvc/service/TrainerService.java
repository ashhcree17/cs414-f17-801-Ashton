package csu.springmvc.service;

import csu.springmvc.model.Login;
import csu.springmvc.model.Trainer;

public interface TrainerService {

  void registerTrainer(Trainer trainer);
  void createTrainer(Trainer trainer);
  Trainer validateTrainer(Login login);

}
