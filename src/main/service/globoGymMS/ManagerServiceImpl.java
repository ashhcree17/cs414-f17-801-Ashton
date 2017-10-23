package globoGymMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import globoGymMS.Manager;
import globoGymMS.ManagerDao;

@Service("managerService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ManagerServiceImpl {
	@Autowired
	private ManagerDao managerDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addManager(Manager manager) {
		managerDao.addManager(manager);
	}
	
	public List<Manager> listManagers() {
		return managerDao.listManagers();
	}
	
	public Manager getManager(int id) {
		return managerDao.getManager(id);
	}
	
	public void deleteManager(Manager manager) {
		managerDao.deleteManager(manager);
	}
}
