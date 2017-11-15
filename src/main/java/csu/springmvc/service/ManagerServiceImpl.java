package csu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import csu.springmvc.dao.ManagerDao;
import csu.springmvc.model.Login;
import csu.springmvc.model.Manager;

public class ManagerServiceImpl implements ManagerService {

  @Autowired
  public ManagerDao managerDao;

  public void register(Manager manager) {
    managerDao.addManager(manager);
  }

  public Manager validateManager(Login login) {
    return managerDao.validateManager(login);
  }

}
