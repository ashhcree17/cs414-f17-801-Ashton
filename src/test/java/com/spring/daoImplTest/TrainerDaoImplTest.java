package com.spring.daoImplTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.TrainerDao;
import com.spring.model.Trainer;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TrainerDaoImplTest {
     
    @Autowired
    private TrainerDao trainerDao;
    
    Trainer trainer1 = new Trainer();
    Trainer trainer2 = new Trainer();
    
    @Before
    public void setup() {
        trainer1.setTrainerId(1);
        trainer1.setUsername("joe.smith");
        trainer1.setPassword("gymRAT123");
        trainer1.setName("Joe");
        trainer1.setLastName("Smith");
        trainer1.setTrainerAddressId(1);
        trainer1.setPhoneNumber(1234567890);
        trainer1.setEmail("joe@email.com");
        trainer1.setInsurance("Aetna");
        trainer1.setWorkSchedule(null);
        trainer1.setQualifications(null);

        trainer2.setTrainerId(2);
        trainer1.setUsername("john.tucker");
        trainer1.setPassword("GYMrat321");
        trainer1.setName("John");
        trainer1.setLastName("Tucker");
        trainer1.setTrainerAddressId(2);
        trainer1.setPhoneNumber(1234567890);
        trainer1.setEmail("john@email.com");
        trainer1.setInsurance("Aetna");
        trainer1.setWorkSchedule(null);
        trainer1.setQualifications(null);
    }
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddTrainer() {
		trainerDao.addTrainer(trainer1);
		Assert.assertNotNull(trainerDao.getTrainer(trainer1.getTrainerId()));
	}
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteTrainer() {
		trainerDao.addTrainer(trainer1);
        trainerDao.addTrainer(trainer2);

		trainerDao.deleteTrainer(trainer1.getTrainerId());
		Assert.assertNull(trainerDao.getTrainer(trainer1.getTrainerId()));
		Assert.assertNotNull(trainerDao.getTrainer(trainer2.getTrainerId()));
    }
}