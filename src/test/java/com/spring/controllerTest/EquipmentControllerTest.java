package com.spring.controllerTest;

import static org.mockito.Mockito.verify;
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

import com.spring.controller.EquipmentController;
import com.spring.model.Equipment;
import com.spring.service.EquipmentService;

public class EquipmentControllerTest {
	@InjectMocks
	EquipmentController controller;
	
	@Mock
	EquipmentService mockEquipmentService;
	
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
	public void testListEquipment() throws Exception {
		List<Equipment> expectedInventory = Arrays.asList(new Equipment(001, "Equip1", 
				3, null));
        when(mockEquipmentService.listInventory()).thenReturn(expectedInventory);
        
        mockMvc.perform(get("/inventory"))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("listInventory", expectedInventory))
        		.andExpect(view().name("equipment"));
    }
	
	@Test
	public void testGetEquipment() throws Exception {
		Equipment expectedEquipment = new Equipment(002, "Equip2", 
				3, null);
		mockEquipmentService.addEquipment(expectedEquipment);
        when(mockEquipmentService.getEquipment(expectedEquipment.getEquipmentId()))
        		.thenReturn(expectedEquipment);
        
        mockMvc.perform(get("/equipment/" + expectedEquipment.getEquipmentId()))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("equipment", expectedEquipment))
        		.andExpect(view().name("equipment"));
    }
	
	@Test
	public void testAddEquipment() throws Exception {
		mockMvc.perform(post("/equipment/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("equipmentId:003, name:\"Equip3\","
					+ " quantity:3, exercises:null"
					.getBytes())
			)
			.andExpect(status().isCreated())
			.andExpect(view().name("redirect:/inventory"));
		
		verify(mockEquipmentService).addEquipment(new Equipment(003, "Equip3", 
				3, null));
    }
}
