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
		Routine routine = new Routine(888, "Routine1", 
				null, null);
		mockRoutineService.addRoutine(routine);
		verify(mockRoutineService).addRoutine(routine);
        when(mockRoutineService.getRoutine(routine.getRoutineId()))
        		.thenReturn(routine);
        
        mockMvc.perform(get("/routine/{routineId}", 888))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("routine", routine))
        		.andExpect(view().name("routine"));
        
        verify(mockRoutineService, times(2)).getRoutine(888);
        verifyNoMoreInteractions(mockRoutineService);
    }
	
	@Test
	public void testAddRoutine() throws Exception {
		mockMvc.perform(post("/routine/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("routineId:999, name:\"Routine2\","
					+ " exercises:null, customers:null "
					.getBytes())
			)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("redirect:/routines"));

		Routine routine = new Routine(999, "Routine2", 
				null, null);
		when(mockRoutineService.getRoutine(999)).thenReturn(routine);
    }
}
