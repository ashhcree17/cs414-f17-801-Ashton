package csu.springmvc.service;

import csu.springmvc.model.Exercise;

public interface ExerciseService {

  void createExerciseDuration(Exercise exercise);
  void createExerciseSets(Exercise exercise);
  Exercise getExercise(int exerciseid);
}
