package com.spring.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.Routine;

@Repository("routineDao")
public class RoutineDaoImpl implements RoutineDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addRoutine(Routine routine) {
		sessionFactory.getCurrentSession().saveOrUpdate(routine);
	}

	@Override
	public void updateRoutine(Routine routine) {
		sessionFactory.getCurrentSession().update(routine);
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Routine> listRoutines() {
		return (List<Routine>) sessionFactory.getCurrentSession()
				.createQuery("from Routine").list();
	}
	
	@Override
	public Routine getRoutine(int routineId) {
		return (Routine) sessionFactory.getCurrentSession().get(Routine.class, routineId);
	}
	
	@Override
	public void deleteRoutine(int routineId) {
		Routine eq = (Routine) sessionFactory.getCurrentSession().load(Routine.class, new Integer(routineId));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
