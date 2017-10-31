package com.spring.daoImplTest;

import java.util.List;
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

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoutineDaoImplTest {
     
    @Autowired
    private RoutineDao routineDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddRoutine() {
        Routine routine = new Routine();
        routine.setRoutineId(1);
        routine.setName("name");
        routineDao.addRoutine(routine);
         
        List<Routine> routines = routineDao.listRoutines();
         
        Assert.assertEquals(1, routines.size());         
        Assert.assertEquals(routine.getName(), routines.get(0).getName());
    }
}