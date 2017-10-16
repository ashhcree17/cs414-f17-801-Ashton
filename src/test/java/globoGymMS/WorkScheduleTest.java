package globoGymMS;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

public class WorkScheduleTest {
	@Test
	public final void getStartTime() {
		WorkSchedule w = new WorkSchedule(DayOfWeek.FRIDAY, LocalTime.of(11, 30), LocalTime.of(4, 45));
		
		Assert.assertEquals(LocalTime.of(11, 30), w.getStartTime());
	}
}
