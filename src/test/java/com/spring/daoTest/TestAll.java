package com.spring.controllerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	  AddressDaoTest.class,
	  CustomerDaoTest.class,
	  EquipmentDaoTest.class,
	  ExerciseDaoTest.class,
	  InventoryDaoTest.class,
	  ManagerDaoTest.class,
	  RoutineDaoTest.class,
	  TrainerDaoTest.class,
	  WorkScheduleDaoTest.class
})

public class TestAll {
	// the class remains empty,
	// used only as a holder for the above annotations
}
