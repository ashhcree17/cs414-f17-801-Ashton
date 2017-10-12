

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Collections;
import org.junit.Test;

public class ManagerTest {
	Manager m = new Manager("M001", "catsSHOPpretty361");

	@Test
	public final void hireTrainerCreatesNewTrainer() {
		m.hireTrainer("Joe", "Blow", 1234567890, "joe@email.com", new Address(
				"123 Main St", "Apt 12", "Niceville", "CO", 12345), "T001",
				"Aetna", new WorkSchedule(DayOfWeek.FRIDAY, LocalTime.of(9, 0), 
				LocalTime.of(3, 30)), java.util.Collections.singletonList("nice"));
				
		// assert that search returns result when searching for newly hired trainer
//		Assert.assert
	}
}
