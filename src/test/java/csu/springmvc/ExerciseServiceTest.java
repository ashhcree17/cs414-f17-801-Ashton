package csu.springmvc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.model.Exercise;
import csu.springmvc.service.ExerciseService;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ExerciseServiceTest {

  @Autowired
  ExerciseService exerciseService;

  Exercise exercise1 = new Exercise();
  Exercise exercise2 = new Exercise();

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testValidateExerciseDuration() {
    exercise1.setExerciseid(46594);
    exercise1.setName("Barbell Exercise");
    exercise1.setDuration(360);             // in Seconds
    exerciseService.registerDuration(exercise1);
    
    Exercise exerciseChk = exerciseService.getExercise(exercise1.getExerciseid());

    assertEquals("Barbell Exercise", exerciseChk.getName());
  }

  @Test
  public void testValidateExerciseSets() {
    exercise2.setExerciseid(2462);
    exercise2.setName("Dumbbell Exercise");
    exercise2.setNumberOfSets(3);
    exercise2.setRepsPerSet(12);
    exerciseService.registerSets(exercise2);
    
    Exercise exerciseChk = exerciseService.getExercise(exercise2.getExerciseid());

    assertEquals("Dumbbell Exercise", exerciseChk.getName());
  }
}
