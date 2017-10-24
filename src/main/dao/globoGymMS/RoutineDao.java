package globoGymMS;

import java.util.List;
import globoGymMS.Routine;

public interface RoutineDao {
	public void addRoutine(Routine routine);
	public List<Routine> listRoutines();
	public Routine getRoutine(int routineId);
	public void deleteRoutine(Routine routine);
}
