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
		mockMvc = standaloneSetup(controller)
                .setSingleView(mockView)
                .build();
	}
	
	@Test
	public void testListEquipmentInGroup() {
		List<Equipment> expectedInventory = Arrays.asList(new Equipment());
        when(mockEquipmentService.listInventory()).thenReturn(expectedInventory);

        Model model = (Model) new Equipment();
        model.addAttribute("listInventory", mockEquipmentService.listInventory());
        String viewName = controller.listInventory(model);

        Assert.assertEquals("inventory", viewName);
        Assert.assertTrue(model.containsAttribute("listInventory"));
    }
	
	@Test
	public void testGetEquipment() throws Exception {
		this.mockMvc.perform(get("/equipment/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.equipmentId").value(1));
    }
	
	@Test
	public void testAddEquipment() throws Exception {
		Equipment equipment = new Equipment();
		equipment.setEquipmentId(1);
		mockEquipmentService.addEquipment(equipment);

        Model model = (Model) new Equipment();
        model.addAttribute("listInventory", mockEquipmentService.listInventory());
		
		this.mockMvc.perform(get("/equipment/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.equipmentId").value(1));
    }
}
