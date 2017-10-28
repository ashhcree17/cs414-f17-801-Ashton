package service;

import java.util.List;

import model.Trainer;

public interface TrainerService {
	public void addTrainer(Trainer trainer);
	public List<Trainer> listTrainers();
	public Trainer getTrainer(int id);
	public void deleteTrainer(Trainer trainer);
}
