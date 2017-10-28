package dao;

import java.util.List;
import model.Routine;

public interface RoutineDao {
	public void addRoutine(Routine routine);
	public void updateRoutine(Routine routine);
	public List<Routine> listRoutines();
	public Routine getRoutine(int routineId);
	public void deleteRoutine(Routine routine);
}
