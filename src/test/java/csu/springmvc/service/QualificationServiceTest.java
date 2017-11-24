package csu.springmvc.service;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.model.Qualification;
import csu.springmvc.service.QualificationService;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class QualificationServiceTest {

  @Autowired
  QualificationService qualificationService;

  Qualification qualification = new Qualification();

  @Before
  public void setUp() throws Exception {
    qualification.setQualificationid(2635);
    qualification.setName("CPR Certified");
    qualificationService.createQualification(qualification);
  }

  @Test
  public void testValidateQualification() {
    Qualification qualificationChk = qualificationService.getQualification(qualification.getQualificationid());

    assertEquals("CPR Certified", qualificationChk.getName());
  }
}
