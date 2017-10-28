package main.globoGymMS.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.globoGymMS.model.Qualification;

@Repository("qualificationDao")
public class QualificationDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addQualification(Qualification qualification) {
		sessionFactory.getCurrentSession().saveOrUpdate(qualification);
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Qualification> listQualifications() {
		return (List<Qualification>) sessionFactory.getCurrentSession()
				.createCriteria(Qualification.class).list();
	}
	
	public Qualification getQualification(int qualId) {
		return (Qualification) sessionFactory.getCurrentSession().get(Qualification.class, qualId);
	}
	
	public void deleteQualification(Qualification qualification) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Qualification WHERE id = "+qualification.getQualId());
	}
}
