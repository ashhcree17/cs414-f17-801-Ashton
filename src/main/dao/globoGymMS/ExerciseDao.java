package globoGymMS;

import java.util.List;

public interface ExerciseDao {
	public void addExercise(Exercise exercise);
	public List<Exercise> listExercises();
	public Exercise getExercise(int exerciseId);
	public void deleteExercise(Exercise exercise);
}
