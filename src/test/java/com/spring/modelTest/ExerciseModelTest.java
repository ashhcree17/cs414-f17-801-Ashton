package com.spring.modelTest;

//import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
//import junit.framework.Assert;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//import com.spring.dao.ExerciseDao;
//import com.spring.model.Exercise;
//import com.spring.model.MembershipStatus;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExerciseModelTest {
     
//    @Autowired
//    private ExerciseDao exerciseDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddExercise() {
//        Exercise exercise = new Exercise();
//        exercise.setExerciseId(1);
//        exercise.setName("name");
//        exercise.setLastName("lastName");
//        exercise.setExerciseExerciseId(12);
//        exercise.setPhoneNumber(1234567890);
//        exercise.setEmail("email@email.com");
//        exercise.setInsurance("Aetna");
//        exercise.setMembership(MembershipStatus.ACTIVE);
//        exerciseDao.addExercise(exercise);
//         
//        List<Exercise> exercises = exerciseDao.listExercises();
//         
//        Assert.assertEquals(1, exercises.size());         
//        Assert.assertEquals(exercise.getName(), exercises.get(0).getName());
    }
}