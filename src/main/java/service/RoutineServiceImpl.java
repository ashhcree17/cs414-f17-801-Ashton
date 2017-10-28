package main.globoGymMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import main.java.globoGymMS.dao.RoutineDao;
import main.java.globoGymMS.model.Routine;

@Service("routineService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

public class RoutineServiceImpl {
	@Autowired
	private RoutineDao routineDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRoutine(Routine routine) {
		routineDao.addRoutine(routine);
	}
	
	public List<Routine> listRoutines() {
		return routineDao.listRoutines();
	}
	
	public Routine getRoutine(int routineId) {
		return routineDao.getRoutine(routineId);
	}
	
	public void deleteRoutine(Routine routine) {
		routineDao.deleteRoutine(routine);
	}
}
