package globoGymMS;

import java.util.List;
import globoGymMS.Exercise;

public interface ExerciseDao {
	public void addExercise(Exercise exercise);
	public List<Exercise> listExercises();
	public Exercise getExercise(int exerciseId);
	public void deleteExercise(Exercise exercise);
}
