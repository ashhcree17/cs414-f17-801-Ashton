package csu.springmvc.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.dao.ExerciseDao;
import csu.springmvc.model.Exercise;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ExerciseDaoImplTest {
  
  @Autowired
  private ExerciseDao exerciseDao;

  Exercise exercise1 = new Exercise();
  Exercise exercise2 = new Exercise();

  @Before
  public void setup() {
      exercise1.setExerciseid(1);
      exercise1.setName("Exercise1");
      exercise1.setDuration(120);     // in seconds
      exercise1.setNumberOfSets(0);
      exercise1.setRepsPerSet(0);

      exercise2.setExerciseid(2);
      exercise1.setName("Exercise1");
      exercise1.setDuration(120);     // in seconds
      exercise1.setNumberOfSets(0);
      exercise1.setRepsPerSet(0);
  }
  
  @Test
  public void testAddExercise() {
      exerciseDao.registerDuration(exercise1);
      
      Assert.assertEquals("Exercise1", 
          exerciseDao.getExercise(exercise1.getExerciseid()).getName());
  }
  
}
