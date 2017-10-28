package main.globoGymMS.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.globoGymMS.model.Routine;

@Repository("routineDao")
public class RoutineDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addRoutine(Routine routine) {
		sessionFactory.getCurrentSession().saveOrUpdate(routine);
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Routine> listRoutines() {
		return (List<Routine>) sessionFactory.getCurrentSession()
				.createCriteria(Routine.class).list();
	}
	
	public Routine getRoutine(int routineId) {
		return (Routine) sessionFactory.getCurrentSession().get(Routine.class, routineId);
	}
	
	public void deleteRoutine(Routine routine) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Routine WHERE id = "+routine.getRoutineId());
	}
}
