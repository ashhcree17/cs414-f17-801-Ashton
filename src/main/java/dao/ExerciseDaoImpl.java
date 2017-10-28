package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Exercise;

@Repository("exerciseDao")
public class ExerciseDaoImpl implements ExerciseDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addExercise(Exercise exercise) {
		sessionFactory.getCurrentSession().persist(exercise);		
	}
	
	@Override
	public void updateExercise(Exercise exercise) {
		sessionFactory.getCurrentSession().update(exercise);
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Exercise> listExercises() {
		return (List<Exercise>) sessionFactory.getCurrentSession()
				.createCriteria(Exercise.class).list();
	}
	
	public Exercise getExercise(int exerciseId) {
		return (Exercise) sessionFactory.getCurrentSession().get(Exercise.class, exerciseId);
	}
	
	public void deleteExercise(Exercise exercise) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Exercise WHERE exerciseId = "+exercise.getExerciseId());
	}
}
