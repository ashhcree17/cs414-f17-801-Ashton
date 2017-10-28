package main.service.globoGymMS;

import java.util.List;
import main.model.globoGymMS.WorkSchedule;

public interface WorkScheduleService {
	public void addWorkSchedule(WorkSchedule workSchedule);
	public List<WorkSchedule> listWorkSchedules();
	public WorkSchedule getWorkSchedule(int workScheduleId);
	public void deleteWorkSchedule(WorkSchedule workSchedule);
}
