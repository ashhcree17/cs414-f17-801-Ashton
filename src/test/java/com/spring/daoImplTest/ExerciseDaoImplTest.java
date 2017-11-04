package com.spring.daoImplTest;

import java.time.Duration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ExerciseDao;
import com.spring.model.Exercise;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExerciseDaoImplTest {
     
    @Autowired
    private ExerciseDao exerciseDao;
    
    Exercise exercise1 = new Exercise();
    Exercise exercise2 = new Exercise();
    
    @Before
    public void setup() {
        exercise1.setExerciseId(1);
        exercise1.setName("Equip1");
        exercise1.setDuration(Duration.ofSeconds(120));
        exercise1.setNumberOfSets(3);
        exercise1.setRepsPerSet(6);

        exercise2.setExerciseId(2);
        exercise1.setName("Equip1");
        exercise1.setDuration(Duration.ofSeconds(60));
        exercise1.setNumberOfSets(6);
        exercise1.setRepsPerSet(3);
    }
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddExercise() {
		exerciseDao.addExercise(exercise1);
		Assert.assertNotNull(exerciseDao.getExercise(exercise1.getExerciseId()));
}
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteExercise() {
		exerciseDao.addExercise(exercise1);
        exerciseDao.addExercise(exercise2);

		exerciseDao.deleteExercise(exercise1.getExerciseId());
		Assert.assertNull(exerciseDao.getExercise(exercise1.getExerciseId()));
		Assert.assertNotNull(exerciseDao.getExercise(exercise2.getExerciseId()));
    }
}