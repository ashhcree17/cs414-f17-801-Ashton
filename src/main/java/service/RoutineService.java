package main.globoGymMS.service;

import java.util.List;

import main.java.globoGymMS.model.Routine;

public interface RoutineService {
	public void addRoutine(Routine routine);
	public List<Routine> listRoutines();
	public Routine getRoutine(int routineId);
	public void deleteRoutine(Routine routine);
}
