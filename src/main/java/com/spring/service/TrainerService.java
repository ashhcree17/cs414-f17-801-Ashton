package com.spring.service;

import java.util.List;

import com.spring.model.Trainer;

public interface TrainerService {
	public void addTrainer(Trainer trainer);
	public void updateTrainer(Trainer trainer);
	public List<Trainer> listTrainers();
	public Trainer getTrainer(int id);
	public void deleteTrainer(Trainer trainer);
}
