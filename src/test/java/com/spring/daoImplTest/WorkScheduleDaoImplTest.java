package com.spring.daoImplTest;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
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

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkScheduleDaoImplTest {
     
    @Autowired
    private WorkScheduleDao workScheduleDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddWorkSchedule() {
        WorkSchedule workSchedule = new WorkSchedule();
        workSchedule.setWorkScheduleId(1);
        workSchedule.setDay(DayOfWeek.FRIDAY);
        workSchedule.setStartTime(LocalTime.of(10, 30));
        workSchedule.setEndTime(LocalTime.of(4, 30));
        workScheduleDao.addWorkSchedule(workSchedule);
         
        List<WorkSchedule> workSchedules = workScheduleDao.listWorkSchedules();
         
        Assert.assertEquals(1, workSchedules.size());         
        Assert.assertEquals(workSchedule.getDay(), workSchedules.get(0).getDay());
    }
}