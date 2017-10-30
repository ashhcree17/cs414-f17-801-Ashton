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

import com.spring.controller.ManagerController;
import com.spring.model.Manager;
import com.spring.service.ManagerService;

public class ManagerControllerTest {
	@InjectMocks
	ManagerController controller;
	
	@Mock
	ManagerService mockManagerService;
	
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
	public void testListManagers() {
		List<Manager> expectedManagers = Arrays.asList(new Manager());
        when(mockManagerService.listManagers()).thenReturn(expectedManagers);

        Model model = (Model) new Manager();
        model.addAttribute("listManagers", mockManagerService.listManagers());
        String viewName = controller.listManagers(model);

        Assert.assertEquals("managers", viewName);
        Assert.assertTrue(model.containsAttribute("listManagers"));
    }
	
	@Test
	public void testGetManager() throws Exception {
		this.mockMvc.perform(get("/manager/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.managerId").value(1));
    }
	
	@Test
	public void testAddManager() throws Exception {
		Manager manager = new Manager();
		manager.setManagerId(1);
		mockManagerService.addManager(manager);

        Model model = (Model) new Manager();
        model.addAttribute("listManagers", mockManagerService.listManagers());
		
		this.mockMvc.perform(get("/manager/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.managerId").value(1));
    }
}
