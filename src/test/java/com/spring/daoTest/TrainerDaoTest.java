package com.spring.controllerTest;

import java.util.List;
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

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TrainerDaoTest {
     
    @Autowired
    private TrainerDao trainerDao;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddTrainer() {
        Trainer trainer = new Trainer();
        trainer.setTrainerId(1);
        trainer.setUsername("username");
        trainer.setPassword("password");
        trainer.setName("name");
        trainer.setLastName("lastName");
        trainer.setTrainerAddressId(123);
        trainer.setPhoneNumber(1234567890);
        trainer.setEmail("email@email.com");
        trainer.setInsurance("Aetna");
        trainerDao.addTrainer(trainer);
         
        List<Trainer> trainers = trainerDao.listTrainers();
         
        Assert.assertEquals(1, trainers.size());         
        Assert.assertEquals(trainer.getName(), trainers.get(0).getName());
    }
}