package com.spring.serviceImplTest;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Routine;
import com.spring.service.RoutineService;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoutineServiceImplTest {
	
	@Autowired
	private RoutineService routineService;

    Routine routine1 = new Routine();
    Routine routine2 = new Routine();
	
	@Before
	public void setup() {
        routine1.setRoutineId(111);
        routine1.setName("Routine1");
        routine1.setExercises(null);
        routine1.setCustomers(null);

        routine2.setRoutineId(222);
        routine1.setName("Routine2");
        routine1.setExercises(null);
        routine1.setCustomers(null);
	}
    
   @Test
   @Transactional
   @Rollback(true)
   public void testAddRoutine() {
   		routineService.addRoutine(routine1);
		Assert.assertNotNull(routineService.getRoutine(routine1.getRoutineId()));
   }
   
   @Test
   @Transactional
   @Rollback(true)
   public void testDeleteRoutine() {
		routineService.addRoutine(routine1);
		routineService.addRoutine(routine2);

		routineService.deleteRoutine(routine1.getRoutineId());
		Assert.assertNull(routineService.getRoutine(routine1.getRoutineId()));
		Assert.assertNotNull(routineService.getRoutine(routine2.getRoutineId()));
   }
}