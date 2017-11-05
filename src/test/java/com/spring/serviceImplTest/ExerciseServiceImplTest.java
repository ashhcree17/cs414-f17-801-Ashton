package com.spring.serviceImplTest;

import junit.framework.Assert;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Exercise;
import com.spring.service.ExerciseService;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExerciseServiceImplTest {
	
	@Autowired
	private ExerciseService exerciseService;

    Exercise exercise1 = new Exercise();
    Exercise exercise2 = new Exercise();
	
	@Before
	public void setup() {
        exercise1.setExerciseId(111);
        exercise1.setName("Equip1");
        exercise1.setDuration(Duration.ofSeconds(120));
        exercise1.setNumberOfSets(3);
        exercise1.setRepsPerSet(6);

        exercise2.setExerciseId(222);
        exercise1.setName("Equip1");
        exercise1.setDuration(Duration.ofSeconds(60));
        exercise1.setNumberOfSets(6);
        exercise1.setRepsPerSet(3);
	}
    
   @Test
   @Transactional
   @Rollback(true)
   public void testAddExercise() {
   		exerciseService.addExercise(exercise1);
		Assert.assertNotNull(exerciseService.getExercise(exercise1.getExerciseId()));
   }
   
   @Test
   @Transactional
   @Rollback(true)
   public void testDeleteExercise() {
		exerciseService.addExercise(exercise1);
		exerciseService.addExercise(exercise2);

		exerciseService.deleteExercise(exercise1.getExerciseId());
		Assert.assertNull(exerciseService.getExercise(exercise1.getExerciseId()));
		Assert.assertNotNull(exerciseService.getExercise(exercise2.getExerciseId()));
   }
}