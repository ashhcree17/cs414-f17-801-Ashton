package csu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.WorkScheduleDao;
import csu.springmvc.model.WorkSchedule;

public class WorkScheduleServiceImpl implements WorkScheduleService {

  @Autowired
  public WorkScheduleDao workScheduleDao;

  public void createWorkSchedule(WorkSchedule workSchedule) {
    workScheduleDao.createWorkSchedule(workSchedule);
  }

  public WorkSchedule getWorkSchedule(int workScheduleid) {
    return workScheduleDao.getWorkSchedule(workScheduleid);
  }
}
