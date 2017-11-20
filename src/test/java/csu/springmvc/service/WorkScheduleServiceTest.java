package csu.springmvc.service;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.model.WorkSchedule;
import csu.springmvc.service.WorkScheduleService;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkScheduleServiceTest {

  @Autowired
  WorkScheduleService workScheduleService;

  WorkSchedule workSchedule = new WorkSchedule();

  @Before
  public void setUp() throws Exception {
    workSchedule.setWorkScheduleid(2474);
    workSchedule.setDay(Date.valueOf(LocalDate.of(2017, 11, 20)));
    workSchedule.setStartTime("10:30 AM");
    workSchedule.setEndTime("06:30 PM");
    workScheduleService.register(workSchedule);
  }

  @Test
  public void testValidateWorkSchedule() {
    WorkSchedule workScheduleChk = workScheduleService.getWorkSchedule(workSchedule.getWorkScheduleid());
    assertEquals("10:30 AM", workScheduleChk.getStartTime());
  }
}
