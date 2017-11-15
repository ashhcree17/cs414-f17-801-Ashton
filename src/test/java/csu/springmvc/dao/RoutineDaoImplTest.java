package csu.springmvc.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.dao.RoutineDao;
import csu.springmvc.model.Routine;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class RoutineDaoImplTest {
  
  @Autowired
  private RoutineDao routineDao;

  Routine routine1 = new Routine();
  Routine routine2 = new Routine();

  @Before
  public void setup() {
      routine1.setRoutineid(3);
      routine1.setName("Routine1");
      routine1.setExercises(null);

      routine2.setRoutineid(4);
      routine2.setName("Routine2");
      routine2.setExercises(null);
  }
  
  @Test
  public void testAddRoutine() {
      routineDao.addRoutine(routine1);
      
      Assert.assertEquals("Routine1", 
          routineDao.getRoutine(routine1.getRoutineid()).getName());
  }
  
}
