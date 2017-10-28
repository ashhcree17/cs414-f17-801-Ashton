package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.TrainerDao;
import model.Trainer;

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
	
	public Trainer getTrainer(int id) {
		return trainerDao.getTrainer(id);
	}
	
	public void deleteTrainer(Trainer trainer) {
		trainerDao.deleteTrainer(trainer);
	}
}
