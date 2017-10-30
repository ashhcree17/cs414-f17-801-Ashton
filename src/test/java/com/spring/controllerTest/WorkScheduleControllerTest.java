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
}
