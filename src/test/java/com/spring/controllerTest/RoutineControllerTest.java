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

import com.spring.controller.RoutineController;
import com.spring.model.Routine;
import com.spring.service.RoutineService;

public class RoutineControllerTest {
	@InjectMocks
	RoutineController controller;
	
	@Mock
	RoutineService mockRoutineService;
	
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
	public void testListRoutine() throws Exception {
		List<Routine> expectedRoutines = Arrays.asList(new Routine(001, "Routine1", 
				null, null));
        when(mockRoutineService.listRoutines()).thenReturn(expectedRoutines);
        
        mockMvc.perform(get("/routines"))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("listRoutines", expectedRoutines))
        		.andExpect(view().name("routine"));
    }
	
	@Test
	public void testGetRoutine() throws Exception {
		Routine expectedRoutine = new Routine(002, "Routine2", 
				null, null);
		mockRoutineService.addRoutine(expectedRoutine);
        when(mockRoutineService.getRoutine(expectedRoutine.getRoutineId()))
        		.thenReturn(expectedRoutine);
        
        mockMvc.perform(get("/routine/" + expectedRoutine.getRoutineId()))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("routine", expectedRoutine))
        		.andExpect(view().name("routine"));
    }
	
	@Test
	public void testAddRoutine() throws Exception {
		mockMvc.perform(post("/routine/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("routineId:003, name:\"Routine3\","
					+ " exercises:null, customers:null "
					.getBytes())
			)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("redirect:/routines"));
		
		verify(mockRoutineService).addRoutine(new Routine(003, "Routine3", 
				null, null));
    }
}
