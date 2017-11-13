package csu.springmvc.dao;

import csu.springmvc.model.Exercise;

public interface ExerciseDao {

  void registerDuration(Exercise exercise);
  void registerSets(Exercise exercise);
  Exercise getExercise(int exerciseid);
}
