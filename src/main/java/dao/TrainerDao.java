package main.globoGymMS.dao;

import java.util.List;

import main.globoGymMS.model.Trainer;

public interface TrainerDao {
	public void addTrainer(Trainer trainer);
	public List<Trainer> listTrainers();
	public Trainer getTrainer(int id);
	public void deleteTrainer(Trainer trainer);
}
