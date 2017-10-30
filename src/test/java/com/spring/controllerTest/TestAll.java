package com.spring.controllerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	  AddressControllerTest.class,
	  CustomerControllerTest.class,
	  EquipmentControllerTest.class,
	  ExerciseControllerTest.class,
	  ManagerControllerTest.class,
	  RoutineControllerTest.class,
	  TrainerControllerTest.class,
	  WorkScheduleControllerTest.class
})

public class TestAll {
	// the class remains empty,
	// used only as a holder for the above annotations
}
