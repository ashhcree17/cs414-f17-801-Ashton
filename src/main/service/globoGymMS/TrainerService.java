package globoGymMS;

import java.util.List;
import globoGymMS.Trainer;

public interface TrainerService {
	public void addTrainer(Trainer trainer);
	public List<Trainer> listTrainers();
	public Trainer getTrainer(int id);
	public void deleteTrainer(Trainer trainer);
}
