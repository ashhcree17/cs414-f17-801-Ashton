package com.spring.daoImplTest;

import java.util.List;
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

@ContextConfiguration(locations = "classpath:servlet-context-test.xml")
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
		List<Routine> routines = routineDao.listRoutines();

		routineDao.addRoutine(routine1);
    Assert.assertEquals(1, routines.size());         
		
    routineDao.addRoutine(routine2);
    Assert.assertEquals(2, routines.size());         
	 
    Assert.assertEquals(routine1.getName(), routines.get(0).getName());
}
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteRoutine() {
		routineDao.addRoutine(routine1);
        routineDao.addRoutine(routine2);

		routineDao.deleteRoutine(routine1.getRoutineId());
        Assert.assertEquals(1, routineDao.listRoutines().size());
    }
}