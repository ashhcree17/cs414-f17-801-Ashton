package main.dao.globoGymMS;

import java.util.List;
import main.model.globoGymMS.Exercise;

public interface ExerciseDao {
	public void addExercise(Exercise exercise);
	public List<Exercise> listExercises();
	public Exercise getExercise(int exerciseId);
	public void deleteExercise(Exercise exercise);
}
