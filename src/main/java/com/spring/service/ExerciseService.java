package com.spring.service;

import java.util.List;

import com.spring.model.Exercise;

public interface ExerciseService {
	public void addExercise(Exercise exercise);
	public void updateExercise(Exercise exercise);
	public List<Exercise> listExercises();
	public Exercise getExercise(int exerciseId);
	public void deleteExercise(int exerciseId);
}
