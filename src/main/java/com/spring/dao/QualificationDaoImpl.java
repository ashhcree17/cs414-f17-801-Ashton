package com.spring.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.Qualification;

@Repository
public class QualificationDaoImpl implements QualificationDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addQualification(Qualification qualification) {
		sessionFactory.getCurrentSession().persist(qualification);
	}

	@Override
	public void updateQualification(Qualification qualification) {
		sessionFactory.getCurrentSession().update(qualification);
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Qualification> listQualifications() {
		return (List<Qualification>) sessionFactory.getCurrentSession()
				.createQuery("from Qualification").list();
	}
	
	@Override
	public Qualification getQualification(int qualId) {
		return (Qualification) sessionFactory.getCurrentSession().get(Qualification.class, qualId);
	}
	
	@Override
	public void deleteQualification(int qualId) {
		Qualification eq = (Qualification) sessionFactory.getCurrentSession().load(Qualification.class, new Integer(qualId));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
