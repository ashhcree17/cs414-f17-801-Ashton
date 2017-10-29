package service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import dao.ManagerDao;
import model.Manager;

import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;
	
	public void setManagerDao(ManagerDao md) {
		this.managerDao = md;
	}
	
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
