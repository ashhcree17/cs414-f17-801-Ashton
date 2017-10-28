package main.globoGymMS.service;

import java.util.List;

import main.java.globoGymMS.model.Exercise;

public interface ExerciseService {
	public void addExercise(Exercise exercise);
	public List<Exercise> listExercises();
	public Exercise getExercise(int exerciseId);
	public void deleteExercise(Exercise exercise);
}
