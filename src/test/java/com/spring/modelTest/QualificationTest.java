package com.spring.modelTest;

//import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
//import junit.framework.Assert;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//import com.spring.dao.QualificationDao;
//import com.spring.model.Qualification;
//import com.spring.model.MembershipStatus;

@RunWith(SpringJUnit4ClassRunner.class)
public class QualificationTest {
     
//    @Autowired
//    private QualificationDao qualificationDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddQualification() {
//        Qualification qualification = new Qualification();
//        qualification.setQualificationId(1);
//        qualification.setName("name");
//        qualification.setLastName("lastName");
//        qualification.setQualificationQualificationId(12);
//        qualification.setPhoneNumber(1234567890);
//        qualification.setEmail("email@email.com");
//        qualification.setInsurance("Aetna");
//        qualification.setMembership(MembershipStatus.ACTIVE);
//        qualificationDao.addQualification(qualification);
//         
//        List<Qualification> qualifications = qualificationDao.listQualifications();
//         
//        Assert.assertEquals(1, qualifications.size());         
//        Assert.assertEquals(qualification.getName(), qualifications.get(0).getName());
    }
}