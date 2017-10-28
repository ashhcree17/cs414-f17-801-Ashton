package main.globoGymMS.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.globoGymMS.model.Exercise;

@Repository("exerciseDao")
public class ExerciseDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEquipment(Exercise exercise) {
		sessionFactory.getCurrentSession().saveOrUpdate(exercise);
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Exercise> listEquipments() {
		return (List<Exercise>) sessionFactory.getCurrentSession()
				.createCriteria(Exercise.class).list();
	}
	
	public Exercise getEquipment(int exerciseId) {
		return (Exercise) sessionFactory.getCurrentSession().get(Exercise.class, exerciseId);
	}
	
	public void deleteEquipment(Exercise exercise) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Exercise WHERE id = "+exercise.getExerciseId());
	}
}
