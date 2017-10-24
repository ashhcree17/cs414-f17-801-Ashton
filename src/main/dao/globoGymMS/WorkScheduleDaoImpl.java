package globoGymMS;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import globoGymMS.WorkSchedule;

@Repository("workScheduleDao")
public class WorkScheduleDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addWorkSchedule(WorkSchedule workSchedule) {
		sessionFactory.getCurrentSession().saveOrUpdate(workSchedule);
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<WorkSchedule> listWorkSchedules() {
		return (List<WorkSchedule>) sessionFactory.getCurrentSession()
				.createCriteria(WorkSchedule.class).list();
	}
	
	public WorkSchedule getWorkSchedule(int id) {
		return (WorkSchedule) sessionFactory.getCurrentSession().get(WorkSchedule.class, id);
	}
	
	public void deleteWorkSchedule(WorkSchedule workSchedule) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM WorkSchedule WHERE id = "+workSchedule.getWorkScheduleId());
	}
}
