package main.dao.globoGymMS;

import java.util.List;
import main.model.globoGymMS.Routine;

public interface RoutineDao {
	public void addRoutine(Routine routine);
	public List<Routine> listRoutines();
	public Routine getRoutine(int routineId);
	public void deleteRoutine(Routine routine);
}
