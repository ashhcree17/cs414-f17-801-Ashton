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
	
	public void addRoutine(Routine routine) {
		sessionFactory.getCurrentSession().persist(routine);
	}

	@Override
	public void updateRoutine(Routine routine) {
		sessionFactory.getCurrentSession().update(routine);
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Routine> listRoutines() {
		return (List<Routine>) sessionFactory.getCurrentSession()
				.createCriteria(Routine.class).list();
	}
	
	public Routine getRoutine(int routineId) {
		return (Routine) sessionFactory.getCurrentSession().get(Routine.class, routineId);
	}
	
	public void deleteRoutine(Routine routine) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Routine WHERE routineId = "+routine.getRoutineId());
	}
}
