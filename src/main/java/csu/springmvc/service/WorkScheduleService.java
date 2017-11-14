package csu.springmvc.service;

import csu.springmvc.model.WorkSchedule;

public interface WorkScheduleService {

  void register(WorkSchedule workSchedule);
  WorkSchedule getWorkSchedule(int workScheduleid);
}
