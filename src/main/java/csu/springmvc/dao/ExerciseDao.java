package csu.springmvc.dao;

import csu.springmvc.model.Exercise;

public interface ExerciseDao {

  void createExerciseDuration(Exercise exercise);
  void createExerciseSets(Exercise exercise);
  Exercise getExercise(int exerciseid);
}
