package csu.springmvc.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.dao.QualificationDao;
import csu.springmvc.model.Qualification;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class QualificationDaoImplTest {
  
  @Autowired
  private QualificationDao qualificationDao;

  Qualification qualification1 = new Qualification();
  Qualification qualification2 = new Qualification();

  @Before
  public void setup() {
      qualification1.setQualificationid(1);
      qualification1.setName("Qual1");

      qualification2.setQualificationid(2);
      qualification2.setName("Qual2");
  }
  
  @Test
  public void testAddQualification() {
      qualificationDao.addQualification(qualification1);
      
      Assert.assertEquals("Qual1", 
          qualificationDao.getQualification(qualification1.getQualificationid()).getName());
  }
  
}
