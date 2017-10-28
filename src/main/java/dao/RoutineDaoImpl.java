package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Routine;

@Repository("routineDao")
public class RoutineDaoImpl implements RoutineDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addRoutine(Routine routine) {
		sessionFactory.getCurrentSession().persist(routine);
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
	public void deleteRoutine(Routine routine) {
		Routine eq = (Routine) sessionFactory.getCurrentSession().load(Routine.class, new Integer(routine.getRoutineId()));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
