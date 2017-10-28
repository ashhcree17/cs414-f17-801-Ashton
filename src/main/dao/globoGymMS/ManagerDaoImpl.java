package main.dao.globoGymMS;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.globoGymMS.Manager;

@Repository("managerDao")
public class ManagerDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addManager(Manager manager) {
		sessionFactory.getCurrentSession().persist(manager);
	}
	
	public void updateManager(Manager manager) {
		sessionFactory.getCurrentSession().update(manager);
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Manager> listManagers() {
		return (List<Manager>) sessionFactory.getCurrentSession()
				.createCriteria(Manager.class).list();
	}
	
	public Manager getManager(int id) {
		return (Manager) sessionFactory.getCurrentSession().get(Manager.class, id);
	}
	
	public void deleteManager(Manager manager) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Manager WHERE id = "+manager.getId());
	}
}
