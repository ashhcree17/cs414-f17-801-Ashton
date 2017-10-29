package com.spring.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.Trainer;

@Repository
public class TrainerDaoImpl implements TrainerDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
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
	public Trainer getTrainer(int trainerId) {
		return (Trainer) sessionFactory.getCurrentSession().get(Trainer.class, trainerId);
	}
	
	@Override
	public void deleteTrainer(int trainerId) {
		Trainer eq = (Trainer) sessionFactory.getCurrentSession().load(Trainer.class, new Integer(trainerId));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
