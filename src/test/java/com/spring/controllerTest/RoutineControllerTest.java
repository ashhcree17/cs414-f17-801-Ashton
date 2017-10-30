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

import com.spring.controller.RoutineController;
import com.spring.model.Routine;
import com.spring.service.RoutineService;

public class RoutineControllerTest {
	@InjectMocks
	RoutineController controller;
	
	@Mock
	RoutineService mockRoutineService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
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
