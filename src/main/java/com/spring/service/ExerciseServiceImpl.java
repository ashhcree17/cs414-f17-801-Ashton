package com.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.spring.dao.ExerciseDao;
import com.spring.model.Exercise;

@Service
public class ExerciseServiceImpl implements ExerciseService {
	@Autowired
	private ExerciseDao exerciseDao;
	
	@Override
	@Transactional
	public void addExercise(Exercise exercise) {
		exerciseDao.addExercise(exercise);
	}

	@Override
	@Transactional
	public void updateExercise(Exercise exercise) {
		exerciseDao.updateExercise(exercise);
	}
	
	@Override
	@Transactional
	public List<Exercise> listExercises() {
		return exerciseDao.listExercises();
	}
	
	@Override
	@Transactional
	public Exercise getExercise(int exerciseId) {
		return exerciseDao.getExercise(exerciseId);
	}
	
	@Override
	@Transactional
	public void deleteExercise(Exercise exercise) {
		exerciseDao.deleteExercise(exercise);
	}
}
