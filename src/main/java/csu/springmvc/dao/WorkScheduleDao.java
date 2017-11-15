package csu.springmvc.dao;

import csu.springmvc.model.WorkSchedule;

public interface WorkScheduleDao {

  void addWorkSchedule(WorkSchedule workSchedule);
  WorkSchedule getWorkSchedule(int workScheduleid);
}
