package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Qualification;

@Repository("qualificationDao")
public class QualificationDaoImpl implements QualificationDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addQualification(Qualification qualification) {
		sessionFactory.getCurrentSession().persist(qualification);
	}

	@Override
	public void updateQualification(Qualification qualification) {
		sessionFactory.getCurrentSession().update(qualification);
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Qualification> listQualifications() {
		return (List<Qualification>) sessionFactory.getCurrentSession()
				.createCriteria(Qualification.class).list();
	}
	
	public Qualification getQualification(int qualId) {
		return (Qualification) sessionFactory.getCurrentSession().get(Qualification.class, qualId);
	}
	
	public void deleteQualification(Qualification qualification) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Qualification WHERE qualId = "+qualification.getQualId());
	}
}
