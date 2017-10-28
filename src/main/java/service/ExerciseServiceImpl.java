package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import dao.ExerciseDao;
import model.Exercise;

@Service("exerciseService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

public class ExerciseServiceImpl {
	@Autowired
	private ExerciseDao exerciseDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addManager(Exercise exercise) {
		exerciseDao.addExercise(exercise);
	}
	
	public List<Exercise> listExercises() {
		return exerciseDao.listExercises();
	}
	
	public Exercise getExercise(int exerciseId) {
		return exerciseDao.getExercise(exerciseId);
	}
	
	public void deleteExercise(Exercise exercise) {
		exerciseDao.deleteExercise(exercise);
	}
}
