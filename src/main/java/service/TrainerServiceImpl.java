package main.globoGymMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import main.java.globoGymMS.dao.TrainerDao;
import main.java.globoGymMS.model.Trainer;

@Service("trainerService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class TrainerServiceImpl {
	@Autowired
	private TrainerDao trainerDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTrainer(Trainer trainer) {
		trainerDao.addTrainer(trainer);
	}
	
	public List<Trainer> listTrainers() {
		return trainerDao.listTrainers();
	}
	
	public Trainer getTrainer(int id) {
		return trainerDao.getTrainer(id);
	}
	
	public void deleteTrainer(Trainer trainer) {
		trainerDao.deleteTrainer(trainer);
	}
}
