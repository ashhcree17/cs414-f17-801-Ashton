package globoGymMS;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TrainerTest {
	@Test
	public final void getWorkSchedule() {
		Address a = new Address("123 Main St", "Apt 123", "Town", "CO", 12345);
		ArrayList<WorkSchedule> ws = new ArrayList<WorkSchedule>();
		ArrayList<Qualification> qs = new ArrayList<Qualification>();
		
		WorkSchedule w = new WorkSchedule(DayOfWeek.MONDAY, LocalTime.of(1, 10), LocalTime.of(7, 10));
		ws.add(w);
		
		Trainer t = new Trainer("Joe", "Blow", a, 1234567890, "joe@email.com", 
				"T01", "Aetna", ws, qs);
		
		Assert.assertEquals(ws, t.getWorkSchedule());
	}
}
