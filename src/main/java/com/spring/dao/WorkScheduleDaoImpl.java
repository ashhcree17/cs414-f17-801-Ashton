package com.spring.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.WorkSchedule;

@Repository
public class WorkScheduleDaoImpl implements WorkScheduleDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
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
	public WorkSchedule getWorkSchedule(int workScheduleId) {
		return (WorkSchedule) sessionFactory.getCurrentSession().get(WorkSchedule.class, workScheduleId);
	}
	
	@Override
	public void deleteWorkSchedule(int workScheduleId) {
		WorkSchedule eq = (WorkSchedule) sessionFactory.getCurrentSession().load(WorkSchedule.class, new Integer(workScheduleId));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}	
	}
}
