package csu.springmvc.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import csu.springmvc.dao.TrainerDao;
import csu.springmvc.model.Trainer;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TrainerDaoImplTest {
  
  @Autowired
  private TrainerDao trainerDao;

  Trainer trainer1 = new Trainer();
  Trainer trainer2 = new Trainer();

  @Before
  public void setup() {
      trainer1.setTrainerid(1);
      trainer1.setUsername("trainerdude");
      trainer1.setPassword("iLOVEtoTRAIN100");
      trainer1.setName("Dude");
      trainer1.setLastname("Trainerman");
      trainer1.setPhonenumber(1234567890);
      trainer1.setEmail("trainerdude@email.com");
      trainer1.setInsurance("Aetna");

      trainer2.setTrainerid(2);
      trainer2.setUsername("dudetrainer");
      trainer2.setPassword("iLOVEtoTRAIN100");
      trainer2.setName("Trainer");
      trainer2.setLastname("Dudeman");
      trainer2.setPhonenumber(1334567890);
      trainer2.setEmail("dudetrainer@email.com");
      trainer2.setInsurance("Aetna");
  }
  
  @Test
  public void testAddTrainer() {
      trainerDao.hire(trainer1);
      
      Assert.assertEquals("Dude", 
          trainerDao.getTrainer(trainer1.getTrainerid()).getName());
  }
  
}
