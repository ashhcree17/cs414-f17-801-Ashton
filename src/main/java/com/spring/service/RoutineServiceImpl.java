package com.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.RoutineDao;
import com.spring.model.Routine;

import org.springframework.stereotype.Service;

@Service("routineService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

public class RoutineServiceImpl implements RoutineService {
	@Autowired
	private RoutineDao routineDao;
	
	@Override
	@Transactional
	public void addRoutine(Routine routine) {
		routineDao.addRoutine(routine);
	}

	@Override
	@Transactional
	public void updateRoutine(Routine routine) {
		routineDao.updateRoutine(routine);
	}
	
	@Override
	@Transactional
	public List<Routine> listRoutines() {
		return routineDao.listRoutines();
	}
	
	@Override
	@Transactional
	public Routine getRoutine(int routineId) {
		return routineDao.getRoutine(routineId);
	}
	
	@Override
	@Transactional
	public void deleteRoutine(Routine routine) {
		routineDao.deleteRoutine(routine);
	}
}
