package main.service.globoGymMS;

import java.util.List;
import main.model.globoGymMS.Exercise;

public interface ExerciseService {
	public void addExercise(Exercise exercise);
	public List<Exercise> listExercises();
	public Exercise getExercise(int exerciseId);
	public void deleteExercise(Exercise exercise);
}
