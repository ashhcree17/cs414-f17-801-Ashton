package com.spring.controllerTest;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.spring.controller.AddressController;
import com.spring.service.AddressService;
import com.spring.model.Address;

public class AddressControllerTest {
	@InjectMocks
	AddressController controller;
	
	@Mock
	AddressService mockAddressService;
	
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
	public void testListAddress() throws Exception {
		List<Address> expectedAddresses = Arrays.asList(new Address());
        when(mockAddressService.listAddresses()).thenReturn(expectedAddresses);

        mockMvc.perform(get("/addresses"))
        	.andExpect(status().isOk())
        	.andExpect(model().attribute("listAddresses", expectedAddresses))
        	.andExpect(view().name("address"));
//        ModelMap modelMap = new ModelMap();
//        String viewName = controller.listAddresses(modelMap);
//
//        Assert.assertEquals("addresses", viewName);
//        Assert.assertThat(modelMap, hasEntry());
//        Assert.assertTrue(modelMap.containsAttribute("listAddresses"));
    }
	
	@Test
	public void testGetAddress() throws Exception {
		this.mockMvc.perform(get("/address/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.addressId").value(1));
    }
	
	@Test
	public void testAddAddress() throws Exception {
		Address address = new Address();
		address.setAddressId(1);
		mockAddressService.addAddress(address);

        Model model = (Model) new Address();
        model.addAttribute("listAddresses", mockAddressService.listAddresses());
		
		this.mockMvc.perform(get("/address/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.addressId").value(1));
    }
}
