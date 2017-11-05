package com.spring.serviceImplTest;

import junit.framework.Assert;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Trainer;
import com.spring.model.WorkSchedule;
import com.spring.service.WorkScheduleService;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkScheduleServiceImplTest {
	
	@Autowired
	private WorkScheduleService workScheduleService;

    WorkSchedule workSchedule1 = new WorkSchedule();
    WorkSchedule workSchedule2 = new WorkSchedule();
    Trainer trainer1 = new Trainer(1, "trainer1", "cats12pizza", "Joe",
    		"Smith", 1, 1234567890, "joe@email.com", "Aetna", null, null);
    Trainer trainer2 = new Trainer(2, "trainer2", "dogs12cookie", "John",
    		"Paul", 2, 1118675309, "john@email.com", "Aetna", null, null);
    
	@Before
	public void setup() {
        workSchedule1.setWorkScheduleId(111);
        workSchedule1.setDay(DayOfWeek.MONDAY);
        workSchedule1.setStartTime(LocalTime.of(10, 30));
        workSchedule1.setEndTime(LocalTime.of(6, 45));
        workSchedule1.setTrainer(trainer1);

        workSchedule2.setWorkScheduleId(222);
        workSchedule1.setDay(DayOfWeek.MONDAY);
        workSchedule1.setStartTime(LocalTime.of(10, 30));
        workSchedule1.setTrainer(trainer2);
	}
    
   @Test
   @Transactional
   @Rollback(true)
   public void testAddWorkSchedule() {
   		workScheduleService.addWorkSchedule(workSchedule1);
		Assert.assertNotNull(workScheduleService.getWorkSchedule(workSchedule1.getWorkScheduleId()));
   }
   
   @Test
   @Transactional
   @Rollback(true)
   public void testDeleteWorkSchedule() {
		workScheduleService.addWorkSchedule(workSchedule1);
		workScheduleService.addWorkSchedule(workSchedule2);

		workScheduleService.deleteWorkSchedule(workSchedule1.getWorkScheduleId());
		Assert.assertNull(workScheduleService.getWorkSchedule(workSchedule1.getWorkScheduleId()));
		Assert.assertNotNull(workScheduleService.getWorkSchedule(workSchedule2.getWorkScheduleId()));
   }
}