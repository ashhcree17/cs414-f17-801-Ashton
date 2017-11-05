package com.spring.serviceImplTest;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Qualification;
import com.spring.service.QualificationService;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class QualificationServiceImplTest {
	
	@Autowired
	private QualificationService qualificationService;

    Qualification qualification1 = new Qualification();
    Qualification qualification2 = new Qualification();
	
	@Before
	public void setup() {
        qualification1.setQualId(111);
        qualification1.setName("Qual1");
        qualification1.setTrainers(null);

        qualification2.setQualId(222);
        qualification1.setName("Qual2");
        qualification1.setTrainers(null);
	}
    
   @Test
   @Transactional
   @Rollback(true)
   public void testAddQualification() {
   		qualificationService.addQualification(qualification1);
		Assert.assertNotNull(qualificationService.getQualification(qualification1.getQualId()));
   }
   
   @Test
   @Transactional
   @Rollback(true)
   public void testDeleteQualification() {
		qualificationService.addQualification(qualification1);
		qualificationService.addQualification(qualification2);

		qualificationService.deleteQualification(qualification1.getQualId());
		Assert.assertNull(qualificationService.getQualification(qualification1.getQualId()));
		Assert.assertNotNull(qualificationService.getQualification(qualification2.getQualId()));
   }
}