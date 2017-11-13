package csu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.ExerciseDao;
import csu.springmvc.model.Exercise;

public class ExerciseServiceImpl implements ExerciseService {

  @Autowired
  public ExerciseDao exerciseDao;

  public void registerDuration(Exercise exercise) {
    exerciseDao.registerDuration(exercise);
  }
  
  public void registerSets(Exercise exercise) {
    exerciseDao.registerSets(exercise);
  }

  public Exercise getExercise(int exerciseid) {
    return exerciseDao.getExercise(exerciseid);
  }
}
