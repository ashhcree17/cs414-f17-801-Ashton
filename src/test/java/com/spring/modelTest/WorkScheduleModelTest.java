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

//import com.spring.dao.WorkScheduleDao;
//import com.spring.model.WorkSchedule;
//import com.spring.model.MembershipStatus;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkScheduleModelTest {
     
//    @Autowired
//    private WorkScheduleDao workScheduleDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddWorkSchedule() {
//        WorkSchedule workSchedule = new WorkSchedule();
//        workSchedule.setWorkScheduleId(1);
//        workSchedule.setName("name");
//        workSchedule.setLastName("lastName");
//        workSchedule.setWorkScheduleWorkScheduleId(12);
//        workSchedule.setPhoneNumber(1234567890);
//        workSchedule.setEmail("email@email.com");
//        workSchedule.setInsurance("Aetna");
//        workSchedule.setMembership(MembershipStatus.ACTIVE);
//        workScheduleDao.addWorkSchedule(workSchedule);
//         
//        List<WorkSchedule> workSchedules = workScheduleDao.listWorkSchedules();
//         
//        Assert.assertEquals(1, workSchedules.size());         
//        Assert.assertEquals(workSchedule.getName(), workSchedules.get(0).getName());
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

//import com.spring.dao.WorkScheduleDao;
//import com.spring.model.WorkSchedule;
//import com.spring.model.MembershipStatus;

@RunWith(SpringJUnit4ClassRunner.class)
public class WorkScheduleModelTest {
     
//    @Autowired
//    private WorkScheduleDao workScheduleDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddWorkSchedule() {
//        WorkSchedule workSchedule = new WorkSchedule();
//        workSchedule.setWorkScheduleId(1);
//        workSchedule.setName("name");
//        workSchedule.setLastName("lastName");
//        workSchedule.setWorkScheduleWorkScheduleId(12);
//        workSchedule.setPhoneNumber(1234567890);
//        workSchedule.setEmail("email@email.com");
//        workSchedule.setInsurance("Aetna");
//        workSchedule.setMembership(MembershipStatus.ACTIVE);
//        workScheduleDao.addWorkSchedule(workSchedule);
//         
//        List<WorkSchedule> workSchedules = workScheduleDao.listWorkSchedules();
//         
//        Assert.assertEquals(1, workSchedules.size());         
//        Assert.assertEquals(workSchedule.getName(), workSchedules.get(0).getName());
    }
}