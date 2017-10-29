package dao;

import java.util.List;

import model.WorkSchedule;

public interface WorkScheduleDao {
	public void addWorkSchedule(WorkSchedule workSchedule);
	public void updateWorkSchedule(WorkSchedule workSchedule);
	public List<WorkSchedule> listWorkSchedules();
	public WorkSchedule getWorkSchedule(int workScheduleId);
	public void deleteWorkSchedule(WorkSchedule workSchedule);
}
