package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Qualification;

@Repository
public class QualificationDaoImpl implements QualificationDao {
	@Autowired
	private SessionFactory sessionFactory;
	
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
	public void deleteQualification(Qualification qualification) {
		Qualification eq = (Qualification) sessionFactory.getCurrentSession().load(Qualification.class, new Integer(qualification.getQualId()));
		if (eq != null) {
			sessionFactory.getCurrentSession().delete(eq);
		}
	}
}
