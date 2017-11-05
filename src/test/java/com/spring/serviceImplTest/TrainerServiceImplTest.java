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

import com.spring.model.Trainer;
import com.spring.service.TrainerService;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TrainerServiceImplTest {
	
	@Autowired
	private TrainerService trainerService;

    Trainer trainer1 = new Trainer();
    Trainer trainer2 = new Trainer();
	
	@Before
	public void setup() {
        trainer1.setTrainerId(111);
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

        trainer2.setTrainerId(222);
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
   		trainerService.addTrainer(trainer1);
		Assert.assertNotNull(trainerService.getTrainer(trainer1.getTrainerId()));
   }
   
   @Test
   @Transactional
   @Rollback(true)
   public void testDeleteTrainer() {
		trainerService.addTrainer(trainer1);
		trainerService.addTrainer(trainer2);

		trainerService.deleteTrainer(trainer1.getTrainerId());
		Assert.assertNull(trainerService.getTrainer(trainer1.getTrainerId()));
		Assert.assertNotNull(trainerService.getTrainer(trainer2.getTrainerId()));
   }
}