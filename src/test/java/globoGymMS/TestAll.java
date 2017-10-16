package globoGymMS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	  AddressTest.class,
	  CustomerTest.class,
	  EquipmentTest.class,
	  ExerciseTest.class,
	  InventoryTest.class,
	  ManagerTest.class,
	  RoutineTest.class,
	  TrainerTest.class,
	  WorkScheduleTest.class
})

public class TestAll {
	// the class remains empty,
	// used only as a holder for the above annotations
}
