package com.spring.controllerTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
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
		mockMvc = standaloneSetup(controller).setSingleView(mockView)
                								.build();
	}
	
	@Test
	public void testListTrainer() throws Exception {
		List<Trainer> expectedTrainers = Arrays.asList(new Trainer(001, "joe.smith1", 
				"cats12yoyo", "Joe", "Smith", 123, 1234567890, "joe@email.com", 
				"Aetna", null, null));
        when(mockTrainerService.listTrainers()).thenReturn(expectedTrainers);
        
        mockMvc.perform(get("/trainers"))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("listTrainers", expectedTrainers))
        		.andExpect(view().name("trainer"));
    }
	
	@Test
	public void testGetTrainer() throws Exception {
		Trainer trainer = new Trainer(330, "joe.smith2", 
				"cats12yoyo", "Joe", "Smith", 123, 1234567890, "joe@email.com", 
				"Aetna", null, null);
		mockTrainerService.addTrainer(trainer);
		verify(mockTrainerService).addTrainer(trainer);
        when(mockTrainerService.getTrainer(trainer.getTrainerId()))
        		.thenReturn(trainer);
        
        mockMvc.perform(get("/trainer/{trainerId}", 330))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("trainer", trainer))
        		.andExpect(view().name("trainer"));
        
        verify(mockTrainerService, times(2)).getTrainer(330);
        verifyNoMoreInteractions(mockTrainerService);
    }
	
	@Test
	public void testAddTrainer() throws Exception {
		mockMvc.perform(post("/trainer/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("trainerId:123, username:\"joe.smith3\","
						+ " password:\"cats12yoyo\", name:\"Joe\","
						+ " lastName:\"Smith\", trainerAddressId:123,"
						+ " phoneNumber:1234567890, email:\"joe@email.com\","
						+ " insurance:\"Aetna\", workSchedule:null,"
						+ " qualifications:null "
					.getBytes())
			)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("redirect:/trainers"));
		
		Trainer trainer = new Trainer(123, "joe.smith", "dogs45spin",
				"Joe", "Smith", 123, 1234567890, "joe@email.com", 
				"Aetna", null, null);
		when(mockTrainerService.getTrainer(123)).thenReturn(trainer);
    }
}
