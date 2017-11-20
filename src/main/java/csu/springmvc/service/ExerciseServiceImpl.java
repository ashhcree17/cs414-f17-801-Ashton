package csu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.ExerciseDao;
import csu.springmvc.model.Exercise;

public class ExerciseServiceImpl implements ExerciseService {

  @Autowired
  public ExerciseDao exerciseDao;

  public void createExerciseDuration(Exercise exercise) {
    exerciseDao.createExerciseDuration(exercise);
  }
  
  public void createExerciseSets(Exercise exercise) {
    exerciseDao.createExerciseSets(exercise);
  }

  public Exercise getExercise(int exerciseid) {
    return exerciseDao.getExercise(exerciseid);
  }
}
