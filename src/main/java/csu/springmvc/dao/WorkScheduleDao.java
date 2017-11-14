package csu.springmvc.dao;

import csu.springmvc.model.WorkSchedule;

public interface WorkScheduleDao {

  void register(WorkSchedule workSchedule);
  WorkSchedule getWorkSchedule(int workScheduleid);
}
