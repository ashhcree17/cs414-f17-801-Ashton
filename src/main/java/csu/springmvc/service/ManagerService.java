package csu.springmvc.service;

import csu.springmvc.model.Login;
import csu.springmvc.model.Manager;

public interface ManagerService {

  void createManager(Manager manager);

  Manager validateManager(Login login);
}
