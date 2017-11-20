package csu.springmvc.service;

import csu.springmvc.model.WorkSchedule;

public interface WorkScheduleService {

  void createWorkSchedule(WorkSchedule workSchedule);
  WorkSchedule getWorkSchedule(int workScheduleid);
}
