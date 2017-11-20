package csu.springmvc.dao;

import csu.springmvc.model.Routine;

public interface RoutineDao {

  void createRoutine(Routine routine);
  Routine getRoutine(int routineid);
}
