package csu.springmvc.service;

import csu.springmvc.model.Exercise;

public interface ExerciseService {

  void registerDuration(Exercise exercise);
  void registerSets(Exercise exercise);
  Exercise getExercise(int exerciseid);
}
