package com.spring.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
}
