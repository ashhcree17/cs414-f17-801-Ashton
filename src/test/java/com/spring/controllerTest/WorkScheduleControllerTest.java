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
	public void testListWorkScheduleInGroup() {
		List<WorkSchedule> expectedWorkSchedules = Arrays.asList(new WorkSchedule());
        when(mockWorkScheduleService.listWorkSchedules()).thenReturn(expectedWorkSchedules);

        Model model = (Model) new WorkSchedule();
        model.addAttribute("listWorkSchedules", mockWorkScheduleService.listWorkSchedules());
        String viewName = controller.listWorkSchedules(model);

        Assert.assertEquals("workSchedules", viewName);
        Assert.assertTrue(model.containsAttribute("listWorkSchedules"));
    }
	
	@Test
	public void testGetWorkSchedule() throws Exception {
		this.mockMvc.perform(get("/workSchedule/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.workScheduleId").value(1));
    }
	
	@Test
	public void testAddWorkSchedule() throws Exception {
		WorkSchedule workSchedule = new WorkSchedule();
		workSchedule.setWorkScheduleId(1);
		mockWorkScheduleService.addWorkSchedule(workSchedule);

        Model model = (Model) new WorkSchedule();
        model.addAttribute("listWorkSchedules", mockWorkScheduleService.listWorkSchedules());
		
		this.mockMvc.perform(get("/workSchedule/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.workScheduleId").value(1));
    }
}
