package com.spring.daoImplTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.RoutineDao;
import com.spring.model.Routine;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoutineDaoImplTest {
     
    @Autowired
    private RoutineDao routineDao;
    
    Routine routine1 = new Routine();
    Routine routine2 = new Routine();
    
    @Before
    public void setup() {
        routine1.setRoutineId(1);
        routine1.setName("Routine1");
        routine1.setExercises(null);
        routine1.setCustomers(null);

        routine2.setRoutineId(2);
        routine1.setName("Routine2");
        routine1.setExercises(null);
        routine1.setCustomers(null);
    }
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddRoutine() {
		routineDao.addRoutine(routine1);
		Assert.assertNotNull(routineDao.getRoutine(routine1.getRoutineId()));
}
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteRoutine() {
		routineDao.addRoutine(routine1);
        routineDao.addRoutine(routine2);

		routineDao.deleteRoutine(routine1.getRoutineId());
		Assert.assertNull(routineDao.getRoutine(routine1.getRoutineId()));
		Assert.assertNotNull(routineDao.getRoutine(routine2.getRoutineId()));
    }
}