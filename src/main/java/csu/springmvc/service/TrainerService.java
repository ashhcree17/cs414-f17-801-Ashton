package csu.springmvc.service;

import csu.springmvc.model.Login;
import csu.springmvc.model.Trainer;

public interface TrainerService {

  void register(Trainer trainer);
  void hire(Trainer trainer);
  Trainer validateTrainer(Login login);

}
