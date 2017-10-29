package dao;

import java.util.List;

import model.Manager;

public interface ManagerDao {
	public void addManager(Manager manager);
	public void updateManager(Manager manager);
	public List<Manager> listManagers();
	public Manager getManager(int id);
	public void deleteManager(Manager manager);
}
