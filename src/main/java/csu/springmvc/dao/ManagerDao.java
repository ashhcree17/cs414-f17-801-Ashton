package csu.springmvc.dao;

import csu.springmvc.model.Login;
import csu.springmvc.model.Manager;

public interface ManagerDao {

  void createManager(Manager manager);
  Manager getManager(int managerid);
  Manager validateManager(Login login);
}
