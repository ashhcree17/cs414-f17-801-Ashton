package com.spring.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Exercise;

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
	@SuppressWarnings({ "unchecked" })
	public List<Exercise> listExercises() {
		return (List<Exercise>) sessionFactory.getCurrentSession()
				.createQuery("from Exercise").list();
	}
	
	@Override
	public Exercise getExercise(int exerciseId) {
		return (Exercise) sessionFactory.getCurrentSession().get(Exercise.class, exerciseId);
	}
	
	@Override
	public void deleteExercise(int exerciseId) {
		Exercise eq = (Exercise) sessionFactory.getCurrentSession().load(Exercise.class, new Integer(exerciseId));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
