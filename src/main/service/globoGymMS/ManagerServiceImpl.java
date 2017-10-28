package globoGymMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import globoGymMS.Manager;
import globoGymMS.ManagerDao;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerDao managerDao;
	
	@Override
	@Transactional
	public void addManager(Manager manager) {
		managerDao.addManager(manager);
	}
	
	@Override
	@Transactional
	public void updateManager(Manager manager) {
		managerDao.updateManager(manager);
	}
	
	@Override
	@Transactional
	public List<Manager> listManagers() {
		return managerDao.listManagers();
	}
	
	@Override
	@Transactional
	public Manager getManager(int id) {
		return managerDao.getManager(id);
	}
	
	@Override
	@Transactional
	public void deleteManager(Manager manager) {
		managerDao.deleteManager(manager);
	}
}
