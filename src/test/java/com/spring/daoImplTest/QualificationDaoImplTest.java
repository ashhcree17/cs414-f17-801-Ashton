package com.spring.daoImplTest;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.QualificationDao;
import com.spring.model.Qualification;

//@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class QualificationDaoImplTest {
     
    @Autowired
    private QualificationDao qualificationDao;
    
    Qualification qualification1 = new Qualification();
    Qualification qualification2 = new Qualification();
    
    @Before
    public void setup() {
        qualification1.setQualId(1);
        qualification1.setName("Qual1");
        qualification1.setTrainers(null);

        qualification2.setQualId(2);
        qualification1.setName("Qual2");
        qualification1.setTrainers(null);
    }
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddQualification() {
		List<Qualification> qualifications = qualificationDao.listQualifications();

		qualificationDao.addQualification(qualification1);
	    Assert.assertEquals(1, qualifications.size());         
			
	    qualificationDao.addQualification(qualification2);
	    Assert.assertEquals(2, qualifications.size());         
		 
	    Assert.assertEquals(qualification1.getName(), qualifications.get(0).getName());
	}
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteQualification() {
		qualificationDao.addQualification(qualification1);
        qualificationDao.addQualification(qualification2);

		qualificationDao.deleteQualification(qualification1.getQualId());
        Assert.assertEquals(1, qualificationDao.listQualifications().size());
    }
}