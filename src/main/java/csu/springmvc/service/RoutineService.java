package csu.springmvc.service;

import csu.springmvc.model.Routine;

public interface RoutineService {

  void register(Routine routine);
  Routine getRoutine(int routineid);
}
