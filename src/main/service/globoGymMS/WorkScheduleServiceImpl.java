package globoGymMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import globoGymMS.WorkSchedule;
import globoGymMS.WorkScheduleDao;

@Service("workScheduleService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class WorkScheduleServiceImpl {
	@Autowired
	private WorkScheduleDao workScheduleDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addWorkSchedule(WorkSchedule workSchedule) {
		workScheduleDao.addWorkSchedule(workSchedule);
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
