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
	public void testListRoutineInGroup() {
		List<Routine> expectedRoutines = Arrays.asList(new Routine());
        when(mockRoutineService.listRoutines()).thenReturn(expectedRoutines);

        Model model = (Model) new Routine();
        model.addAttribute("listRoutines", mockRoutineService.listRoutines());
        String viewName = controller.listRoutines(model);

        Assert.assertEquals("routines", viewName);
        Assert.assertTrue(model.containsAttribute("listRoutines"));
    }
	
	@Test
	public void testGetRoutine() throws Exception {
		this.mockMvc.perform(get("/routine/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.routineId").value(1));
    }
	
	@Test
	public void testAddRoutine() throws Exception {
		Routine routine = new Routine();
		routine.setRoutineId(1);
		mockRoutineService.addRoutine(routine);

        Model model = (Model) new Routine();
        model.addAttribute("listRoutines", mockRoutineService.listRoutines());
		
		this.mockMvc.perform(get("/routine/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.routineId").value(1));
    }
}
