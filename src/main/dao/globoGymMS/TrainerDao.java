package globoGymMS;

import java.util.List;

public interface TrainerDao {
	// HEY YOU LOOK HERE!!!!!!!!!
	// This is where the MySQL db username and password
	// shit can change /usr/local/Cellar/mysql/5.7.20/bin/mysqld

	public void addTrainer(Trainer trainer);
	public List<Trainer> listManagers();
	public Trainer getTrainer(int id);
	public void deleteTrainer(Trainer trainer);
}
