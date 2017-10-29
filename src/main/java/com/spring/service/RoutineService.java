package com.spring.service;

import java.util.List;

import com.spring.model.Routine;

public interface RoutineService {
	public void addRoutine(Routine routine);
	public void updateRoutine(Routine routine);
	public List<Routine> listRoutines();
	public Routine getRoutine(int routineId);
	public void deleteRoutine(int routineId);
}
