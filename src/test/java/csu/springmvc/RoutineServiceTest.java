package csu.springmvc;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.model.Routine;
import csu.springmvc.service.RoutineService;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class RoutineServiceTest {

  @Autowired
  RoutineService routineService;

  Routine routine = new Routine();

  @Before
  public void setUp() throws Exception {
    routine.setRoutineid(2044);
    routine.setName("Example");
    routineService.register(routine);
  }

  @Test
  public void testValidateRoutine() {
    Routine routineChk = routineService.getRoutine(routine.getRoutineid());

    assertEquals("Example", routineChk.getName());
  }
}
