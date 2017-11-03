package com.spring.controllerTest;

import static org.mockito.Mockito.verify;
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
		mockMvc = standaloneSetup(controller)
                .setSingleView(mockView)
                .build();
	}
	
	@Test
	public void testListTrainer() throws Exception {
		List<Trainer> expectedTrainers = Arrays.asList(new Trainer());
        when(mockTrainerService.listTrainers()).thenReturn(expectedTrainers);
        
        mockMvc.perform(get("/customers"))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("listTrainers", expectedTrainers))
        		.andExpect(view().name("customer"));
    }
	
	@Test
	public void testGetTrainer() throws Exception {
		Trainer expectedTrainer = new Trainer();
        when(mockTrainerService.getTrainer(expectedTrainer.getTrainerId()))
        		.thenReturn(expectedTrainer);
        
        mockMvc.perform(get("/customer" + expectedTrainer.getTrainerId()))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("customer", expectedTrainer))
        		.andExpect(view().name("customer"));
    }
	
	@Test
	public void testAddTrainer() throws Exception {
		mockMvc.perform(post("/customer/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("trainerId:123, username:\"joe.smith\", password:\"cats12yoyo\"," 
						+ " name:\"Joe\", lastName:\"Smith\", trainerAddressId:123,"
						+ " phoneNumber:1234567890, email:\"joe@email.com\","
						+ " insurance:\"Aetna\", workSchedule:null, qualifications:null "
					.getBytes())
			)
			.andExpect(status().isCreated())
			.andExpect(view().name("redirect:/customers"));
		
//		verify(mockTrainerService).addTrainer(new Trainer(123, "Joe", 
//				"Smith", 123, 1234567890, "joe@email.com", "Aetna", MembershipStatus.ACTIVE));
		
		verify(mockTrainerService).addTrainer(new Trainer(123, "joe.smith", 
				"cats12yoyo", "Joe", "Smith", 123, 1234567890, "joe@email.com", 
				"Aetna", null, null));
    }
}
