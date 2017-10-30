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

import com.spring.controller.EquipmentController;
import com.spring.model.Equipment;
import com.spring.service.EquipmentService;

public class EquipmentControllerTest {
	@InjectMocks
	EquipmentController controller;
	
	@Mock
	EquipmentService mockEquipmentService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
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
}
