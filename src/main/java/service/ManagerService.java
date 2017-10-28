package main.globoGymMS.service;

import java.util.List;

import main.java.globoGymMS.model.Manager;

public interface ManagerService {
	public void addManager(Manager manager);
	public void updateManager(Manager manager);
	public List<Manager> listManagers();
	public Manager getManager(int id);
	public void deleteManager(Manager manager);
}
