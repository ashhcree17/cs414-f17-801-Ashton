package csu.springmvc.dao;

import csu.springmvc.model.Login;
import csu.springmvc.model.Trainer;

public interface TrainerDao {

  void register(Trainer trainer);

  Trainer validateTrainer(Login login);

}
