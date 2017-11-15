package csu.springmvc.dao;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.dao.WorkScheduleDao;
import csu.springmvc.model.WorkSchedule;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkScheduleDaoImplTest {
  
  @Autowired
  private WorkScheduleDao workScheduleDao;

  WorkSchedule workSchedule1 = new WorkSchedule();
  WorkSchedule workSchedule2 = new WorkSchedule();

  @Before
  public void setup() {
      workSchedule1.setWorkScheduleid(1);
      workSchedule1.setDay(Date.valueOf(LocalDate.of(2017, 11, 20)));
      workSchedule1.setStartTime("10:30 AM");
      workSchedule1.setEndTime("11:30 PM");

      workSchedule2.setWorkScheduleid(2);
      workSchedule2.setDay(Date.valueOf(LocalDate.of(2017, 11, 20)));
      workSchedule2.setStartTime("11:30 AM");
      workSchedule2.setEndTime("10:30 PM");
  }
  
  @Test
  public void testAddWorkSchedule() {
      workScheduleDao.addWorkSchedule(workSchedule1);
      
      Assert.assertEquals("11:30 PM", 
          workScheduleDao.getWorkSchedule(workSchedule1.getWorkScheduleid()).getEndTime());
  }
}
