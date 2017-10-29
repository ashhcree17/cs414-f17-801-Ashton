package com.spring.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.RoutineDao;
import com.spring.model.Routine;

import org.springframework.stereotype.Service;

@Service
public class RoutineServiceImpl implements RoutineService {
	private RoutineDao routineDao;

	public void setRoutineDao(RoutineDao routineDao) {
		this.routineDao = routineDao;
	}
	
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
	public void deleteRoutine(int routineId) {
		routineDao.deleteRoutine(routineId);
	}
}
