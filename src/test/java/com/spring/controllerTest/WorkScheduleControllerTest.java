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

import java.time.DayOfWeek;
import java.time.LocalTime;
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

import com.spring.controller.WorkScheduleController;
import com.spring.model.WorkSchedule;
import com.spring.service.WorkScheduleService;

public class WorkScheduleControllerTest {
	@InjectMocks
	WorkScheduleController controller;
	
	@Mock
	WorkScheduleService mockWorkScheduleService;
	
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
	public void testListWorkSchedule() throws Exception {
		List<WorkSchedule> expectedWorkSchedules = Arrays.asList(new WorkSchedule(001, DayOfWeek.MONDAY, 
				LocalTime.of(4, 30), LocalTime.of(10, 30), null));
        when(mockWorkScheduleService.listWorkSchedules()).thenReturn(expectedWorkSchedules);
        
        mockMvc.perform(get("/workSchedules"))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("listWorkSchedules", expectedWorkSchedules))
        		.andExpect(view().name("workSchedule"));
    }
	
	@Test
	public void testGetWorkSchedule() throws Exception {
		WorkSchedule workSchedule = new WorkSchedule(670, DayOfWeek.MONDAY, 
				LocalTime.of(4, 30), LocalTime.of(10, 30), null);
		mockWorkScheduleService.addWorkSchedule(workSchedule);
		verify(mockWorkScheduleService).addWorkSchedule(workSchedule);
        when(mockWorkScheduleService.getWorkSchedule(workSchedule.getWorkScheduleId()))
        		.thenReturn(workSchedule);
        
        mockMvc.perform(get("/workSchedule/{workScheduleId}", 670))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("workSchedule", workSchedule))
        		.andExpect(view().name("workSchedule"));
        
        verify(mockWorkScheduleService, times(2)).getWorkSchedule(670);
        verifyNoMoreInteractions(mockWorkScheduleService);
    }
	
	@Test
	public void testAddWorkSchedule() throws Exception {
		mockMvc.perform(post("/workSchedule/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("workScheduleId:425, day:DayOfWeek.MONDAY,"
					+ " startTime:LocalTime.of(4, 30),"
					+ " endTime:LocalTime.of(10, 30), trainer:null "
					.getBytes())
			)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("redirect:/workSchedules"));

		WorkSchedule workSchedule = new WorkSchedule(425, DayOfWeek.MONDAY, 
				LocalTime.of(4, 30), LocalTime.of(10, 30), null);
		when(mockWorkScheduleService.getWorkSchedule(425))
			.thenReturn(workSchedule);
    }
}
