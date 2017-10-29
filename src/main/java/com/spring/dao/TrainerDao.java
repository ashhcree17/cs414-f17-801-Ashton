package com.spring.dao;

import java.util.List;

import com.spring.model.Trainer;

public interface TrainerDao {
	public void addTrainer(Trainer trainer);
	public void updateTrainer(Trainer trainer);
	public List<Trainer> listTrainers();
	public Trainer getTrainer(int trainerId);
	public void deleteTrainer(int trainerId);
}
