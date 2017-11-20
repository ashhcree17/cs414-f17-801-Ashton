package csu.springmvc.dao;

import csu.springmvc.model.Login;
import csu.springmvc.model.Trainer;

public interface TrainerDao {

  void registerTrainer(Trainer trainer);
  void createTrainer(Trainer trainer);
  Trainer validateTrainer(Login login);
  Trainer getTrainer(int trainerid);
}
