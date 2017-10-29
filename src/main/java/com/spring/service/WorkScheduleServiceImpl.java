package com.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.WorkScheduleDao;
import com.spring.model.WorkSchedule;

@Service
public class WorkScheduleServiceImpl implements WorkScheduleService {
	@Autowired
	private WorkScheduleDao workScheduleDao;
	
	public void addWorkSchedule(WorkSchedule workSchedule) {
		workScheduleDao.addWorkSchedule(workSchedule);
	}

	@Override
	public void updateWorkSchedule(WorkSchedule workSchedule) {
		workScheduleDao.updateWorkSchedule(workSchedule);
	}
	
	public List<WorkSchedule> listWorkSchedules() {
		return workScheduleDao.listWorkSchedules();
	}
	
	public WorkSchedule getWorkSchedule(int workScheduleId) {
		return workScheduleDao.getWorkSchedule(workScheduleId);
	}
	
	public void deleteWorkSchedule(WorkSchedule workSchedule) {
		workScheduleDao.deleteWorkSchedule(workSchedule);
	}
}
