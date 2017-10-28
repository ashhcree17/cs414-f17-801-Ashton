package main.globoGymMS.service;

import java.util.List;

import main.java.globoGymMS.model.WorkSchedule;

public interface WorkScheduleService {
	public void addWorkSchedule(WorkSchedule workSchedule);
	public List<WorkSchedule> listWorkSchedules();
	public WorkSchedule getWorkSchedule(int workScheduleId);
	public void deleteWorkSchedule(WorkSchedule workSchedule);
}
