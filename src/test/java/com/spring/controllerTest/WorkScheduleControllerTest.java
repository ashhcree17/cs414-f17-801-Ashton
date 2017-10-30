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

import com.spring.controller.WorkScheduleController;
import com.spring.model.WorkSchedule;
import com.spring.service.WorkScheduleService;

public class WorkScheduleControllerTest {
	@InjectMocks
	WorkScheduleController controller;
	
	@Mock
	WorkScheduleService mockWorkScheduleService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
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
}
