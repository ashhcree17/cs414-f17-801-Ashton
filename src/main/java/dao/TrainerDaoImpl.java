package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Trainer;

@Repository("trainerDao")
public class TrainerDaoImpl implements TrainerDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTrainer(Trainer trainer) {
		sessionFactory.getCurrentSession().persist(trainer);
	}

	@Override
	public void updateTrainer(Trainer trainer) {
		sessionFactory.getCurrentSession().update(trainer);
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Trainer> listTrainers() {
		return (List<Trainer>) sessionFactory.getCurrentSession()
				.createQuery("from Trainer").list();
	}
	
	@Override
	public Trainer getTrainer(int id) {
		return (Trainer) sessionFactory.getCurrentSession().get(Trainer.class, id);
	}
	
	@Override
	public void deleteTrainer(Trainer trainer) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Trainer WHERE trainerId = "+trainer.getId());
	}
}
