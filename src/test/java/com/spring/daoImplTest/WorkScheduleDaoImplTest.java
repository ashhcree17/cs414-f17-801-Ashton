package com.spring.daoImplTest;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.WorkScheduleDao;
import com.spring.model.WorkSchedule;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkScheduleDaoImplTest {
     
    @Autowired
    private WorkScheduleDao workScheduleDao;
    
    WorkSchedule workSchedule1 = new WorkSchedule();
    WorkSchedule workSchedule2 = new WorkSchedule();
    
    @Before
    public void setup() {
        workSchedule1.setWorkScheduleId(1);
        workSchedule1.setDay(DayOfWeek.MONDAY);
        workSchedule1.setStartTime(LocalTime.of(10, 30));
        workSchedule1.setEndTime(LocalTime.of(6, 45));

        workSchedule2.setWorkScheduleId(2);
        workSchedule1.setDay(DayOfWeek.MONDAY);
        workSchedule1.setStartTime(LocalTime.of(10, 30));
        workSchedule1.setEndTime(LocalTime.of(6, 45));
    }
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddWorkSchedule() {
		List<WorkSchedule> workSchedules = workScheduleDao.listWorkSchedules();

		workScheduleDao.addWorkSchedule(workSchedule1);
    Assert.assertEquals(1, workSchedules.size());         
		
    workScheduleDao.addWorkSchedule(workSchedule2);
    Assert.assertEquals(2, workSchedules.size());         
	 
    Assert.assertEquals(workSchedule1.getDay(), workSchedules.get(0).getDay());
}
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteWorkSchedule() {
		workScheduleDao.addWorkSchedule(workSchedule1);
        workScheduleDao.addWorkSchedule(workSchedule2);

		workScheduleDao.deleteWorkSchedule(workSchedule1.getWorkScheduleId());
        Assert.assertEquals(1, workScheduleDao.listWorkSchedules().size());
    }
}