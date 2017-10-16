package globoGymMS;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

public class QualificationTest {
	@Test
	public final void getName() {
		Qualification q = new Qualification("QU1");
				
		Assert.assertEquals("QU1", q.getName());
	}
}
