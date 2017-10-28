package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao {
	/*
	 * Type SessionFactory:
	 * 		Creates Sessions. Usually an application has a single SessionFactory. 
	 * 		Threads servicing client requests obtain Sessions from the factory.
	 * */
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Obtains the current session and adds a new Manager entity to 
	 * the persistant context (aka the database).
	 * */
	@Override
	public void addManager(Manager manager) {
		sessionFactory.getCurrentSession().persist(manager);
	}
	
	@Override
	public void updateManager(Manager manager) {
		sessionFactory.getCurrentSession().update(manager);
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Manager> listManagers() {
		return (List<Manager>) sessionFactory.getCurrentSession()
				.createQuery("from Manager").list();
	}
	
	@Override
	public Manager getManager(int id) {
		return (Manager) sessionFactory.getCurrentSession().get(Manager.class, id);
	}
	
	@Override
	public void deleteManager(Manager manager) {
		sessionFactory.getCurrentSession()
			.createQuery("DELETE FROM Manager WHERE managerId = " + manager.getManagerId());
	}
}
