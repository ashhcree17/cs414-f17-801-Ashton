package com.spring.controllerTest;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.spring.controller.TrainerController;
import com.spring.model.Trainer;
import com.spring.service.TrainerService;

public class TrainerControllerTest {
	@InjectMocks
	TrainerController controller;
	
	@Mock
	TrainerService mockTrainerService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testListTrainerInGroup() {
		List<Trainer> expectedTrainers = Arrays.asList(new Trainer());
        when(mockTrainerService.listTrainers()).thenReturn(expectedTrainers);

        Model model = (Model) new Trainer();
        model.addAttribute("listTrainers", mockTrainerService.listTrainers());
        String viewName = controller.listTrainers(model);

        Assert.assertEquals("trainers", viewName);
        Assert.assertTrue(model.containsAttribute("listTrainers"));
    }
}
