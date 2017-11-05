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
		mockMvc = standaloneSetup(controller).setSingleView(mockView)
                								.build();
	}
	
	@Test
	public void testListManagers() throws Exception {
		List<Manager> expectedManagers = Arrays.asList(new Manager(001, "joe.smith", 
				"cats12yoyo", "Joe", "Smith", 123, 1234567890, "joe@email.com", 
				"Aetna"));
        when(mockManagerService.listManagers()).thenReturn(expectedManagers);
        
        mockMvc.perform(get("/managers"))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("listManagers", expectedManagers))
        		.andExpect(view().name("manager"));
    }
	
	@Test
	public void testGetManager() throws Exception {
		Manager manager = new Manager(543, "joe.smith", 
				"cats12yoyo", "Joe", "Smith", 123, 1234567890, 
				"joe@email.com", "Aetna");
		mockManagerService.addManager(manager);
		verify(mockManagerService).addManager(manager);
        when(mockManagerService.getManager(manager.getManagerId()))
        		.thenReturn(manager);
        
        mockMvc.perform(get("/manager/{managerId}", 543))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("manager", manager))
        		.andExpect(view().name("manager"));
        
        verify(mockManagerService, times(2)).getManager(543);
        verifyNoMoreInteractions(mockManagerService);
    }
	
	@Test
	public void testAddManager() throws Exception {
		mockMvc.perform(post("/manager/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("managerId:432, username:\"joe.smith\","
					+ " password:\"cats12yoyo\", name:\"Joe\","
					+ " lastName:\"Smith\", managerAddressId:123,"
					+ " phoneNumber:1234567890, email:\"joe@email.com\","
					+ " insurance:\"Aetna\" "
					.getBytes())
			)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("redirect:/managers"));
		
		Manager manager = new Manager(432, "joe.smith", 
				"cats12yoyo", "Joe", "Smith", 123, 1234567890, 
				"joe@email.com", "Aetna");
		when(mockManagerService.getManager(432)).thenReturn(manager);
    }
}
