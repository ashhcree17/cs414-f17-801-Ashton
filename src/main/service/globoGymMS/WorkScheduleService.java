package globoGymMS;

import java.util.List;
import globoGymMS.WorkSchedule;

public interface WorkScheduleService {
	public void addWorkSchedule(WorkSchedule workSchedule);
	public List<WorkSchedule> listWorkSchedules();
	public WorkSchedule getWorkSchedule(int workScheduleId);
	public void deleteWorkSchedule(WorkSchedule workSchedule);
}
