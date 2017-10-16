package globoGymMS;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class RoutineTest {
	@Test
	public final void getExercises() {
		Exercise e = new Exercise("E1", Duration.ZERO);
		ArrayList<Exercise> es = new ArrayList<Exercise>();
		
		es.add(e);
		Routine r = new Routine("R1", es);

		Assert.assertEquals(es, r.getExercises());
	}
}
