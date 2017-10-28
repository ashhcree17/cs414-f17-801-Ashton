package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.WorkSchedule;

@Repository("workScheduleDao")
public class WorkScheduleDaoImpl implements WorkScheduleDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addWorkSchedule(WorkSchedule workSchedule) {
		sessionFactory.getCurrentSession().persist(workSchedule);
	}

	@Override
	public void updateWorkSchedule(WorkSchedule workSchedule) {
		sessionFactory.getCurrentSession().update(workSchedule);
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<WorkSchedule> listWorkSchedules() {
		return (List<WorkSchedule>) sessionFactory.getCurrentSession()
				.createQuery("from WorkSchedule").list();
	}
	
	@Override
	public WorkSchedule getWorkSchedule(int id) {
		return (WorkSchedule) sessionFactory.getCurrentSession().get(WorkSchedule.class, id);
	}
	
	@Override
	public void deleteWorkSchedule(WorkSchedule workSchedule) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM WorkSchedule WHERE workScheduleId = "+workSchedule.getWorkScheduleId());
	}
}
