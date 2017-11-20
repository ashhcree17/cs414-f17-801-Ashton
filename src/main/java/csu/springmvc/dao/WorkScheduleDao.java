package csu.springmvc.dao;

import csu.springmvc.model.WorkSchedule;

public interface WorkScheduleDao {

  void createWorkSchedule(WorkSchedule workSchedule);
  WorkSchedule getWorkSchedule(int workScheduleid);
}
