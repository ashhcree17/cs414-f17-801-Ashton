package com.spring.controllerTest;

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
		mockMvc = standaloneSetup(controller).setSingleView(mockView)
                								.build();
	}
	
	@Test
	public void testListAddress() throws Exception {
		List<Address> expectedAddresses = Arrays.asList(new Address(001, "246 Main St", 
				"Apt 1", "Denver", "CO", 54321));
        when(mockAddressService.listAddresses()).thenReturn(expectedAddresses);

        mockMvc.perform(get("/addresses"))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("listAddresses", expectedAddresses))
        		.andExpect(view().name("address"));
    }
	
	@Test
	public void testGetAddress() throws Exception {
		Address expectedAddress = new Address(002, "357 Main St", 
				"Apt 1", "Denver", "CO", 24680);
        when(mockAddressService.getAddress(expectedAddress.getAddressId()))
        		.thenReturn(expectedAddress);
        
        mockMvc.perform(get("/address" + expectedAddress.getAddressId()))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("address", expectedAddress))
        		.andExpect(view().name("address"));
    }
	
	@Test
	public void testAddAddress() throws Exception {
		mockMvc.perform(post("/address/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("addressId:003, street1:\"123 Main St\","
						+ " street2:\"Apt 1\", city:\"Denver\","
						+ " state:\"CO\", zipCode:12345".getBytes())
			)
			.andExpect(status().isCreated())
			.andExpect(view().name("redirect:/addresses"));
		
		verify(mockAddressService).addAddress(new Address(003, "123 Main St", 
				"Apt 1", "Denver", "CO", 12345));	
	}
}
