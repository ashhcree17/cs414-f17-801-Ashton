package csu.springmvc.dao;

import csu.springmvc.model.Login;
import csu.springmvc.model.Manager;

public interface ManagerDao {

  void register(Manager manager);

  Manager validateManager(Login login);
}
