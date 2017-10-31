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

//import com.spring.dao.RoutineDao;
//import com.spring.model.Routine;
//import com.spring.model.MembershipStatus;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoutineModelTest {
     
//    @Autowired
//    private RoutineDao routineDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddRoutine() {
//        Routine routine = new Routine();
//        routine.setRoutineId(1);
//        routine.setName("name");
//        routine.setLastName("lastName");
//        routine.setRoutineRoutineId(12);
//        routine.setPhoneNumber(1234567890);
//        routine.setEmail("email@email.com");
//        routine.setInsurance("Aetna");
//        routine.setMembership(MembershipStatus.ACTIVE);
//        routineDao.addRoutine(routine);
//         
//        List<Routine> routines = routineDao.listRoutines();
//         
//        Assert.assertEquals(1, routines.size());         
//        Assert.assertEquals(routine.getName(), routines.get(0).getName());
    }
}
package com.spring.modelTest;

//import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
//import junit.framework.Assert;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//import com.spring.dao.RoutineDao;
//import com.spring.model.Routine;
//import com.spring.model.MembershipStatus;

@RunWith(SpringJUnit4ClassRunner.class)
public class RoutineModelTest {
     
//    @Autowired
//    private RoutineDao routineDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddRoutine() {
//        Routine routine = new Routine();
//        routine.setRoutineId(1);
//        routine.setName("name");
//        routine.setLastName("lastName");
//        routine.setRoutineRoutineId(12);
//        routine.setPhoneNumber(1234567890);
//        routine.setEmail("email@email.com");
//        routine.setInsurance("Aetna");
//        routine.setMembership(MembershipStatus.ACTIVE);
//        routineDao.addRoutine(routine);
//         
//        List<Routine> routines = routineDao.listRoutines();
//         
//        Assert.assertEquals(1, routines.size());         
//        Assert.assertEquals(routine.getName(), routines.get(0).getName());
    }
}