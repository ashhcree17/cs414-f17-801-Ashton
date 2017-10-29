package com.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.TrainerDao;
import com.spring.model.Trainer;

@Service
public class TrainerServiceImpl implements TrainerService {
	@Autowired
	private TrainerDao trainerDao;
	
	public void addTrainer(Trainer trainer) {
		trainerDao.addTrainer(trainer);
	}

	@Override
	public void updateTrainer(Trainer trainer) {
		trainerDao.updateTrainer(trainer);
	}
	
	public List<Trainer> listTrainers() {
		return trainerDao.listTrainers();
	}
	
	public Trainer getTrainer(int trainerId) {
		return trainerDao.getTrainer(trainerId);
	}
	
	public void deleteTrainer(int trainerId) {
		trainerDao.deleteTrainer(trainerId);
	}
}
