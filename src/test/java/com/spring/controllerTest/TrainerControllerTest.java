package com.spring.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

import com.spring.controller.TrainerController;
import com.spring.model.Trainer;
import com.spring.service.TrainerService;

public class TrainerControllerTest {
	@InjectMocks
	TrainerController controller;
	
	@Mock
	TrainerService mockTrainerService;
	
	@Mock
	View mockView;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(controller)
                .setSingleView(mockView)
                .build();
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
	
	@Test
	public void testGetTrainer() throws Exception {
		this.mockMvc.perform(get("/trainer/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.trainerId").value(1));
    }
	
	@Test
	public void testAddTrainer() throws Exception {
		Trainer trainer = new Trainer();
		trainer.setTrainerId(1);
		mockTrainerService.addTrainer(trainer);

        Model model = (Model) new Trainer();
        model.addAttribute("listTrainers", mockTrainerService.listTrainers());
		
		this.mockMvc.perform(get("/trainer/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.trainerId").value(1));
    }
}
