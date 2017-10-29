package dao;

import java.util.List;

import model.Exercise;

public interface ExerciseDao {
	public void addExercise(Exercise exercise);
	public void updateExercise(Exercise exercise);
	public List<Exercise> listExercises();
	public Exercise getExercise(int exerciseId);
	public void deleteExercise(Exercise exercise);
}
