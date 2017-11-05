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
		Address address = new Address (550, "357 Main St", "Apt 1", 
				"Denver", "CO", 24680);
		mockAddressService.addAddress(address);
		verify(mockAddressService).addAddress(address);
		when(mockAddressService.getAddress(550)).thenReturn(address);
        
        mockMvc.perform(get("/address/{addressId}", 550))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("address", address))
        		.andExpect(view().name("address"));
        
        verify(mockAddressService, times(2)).getAddress(550);
        verifyNoMoreInteractions(mockAddressService);
    }
	
	@Test
	public void testAddAddress() throws Exception {
		mockMvc.perform(post("/address/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("addressId:275, street1:\"123 Main St\","
						+ " street2:\"Apt 1\", city:\"Denver\","
						+ " state:\"CO\", zipCode:12345".getBytes())
			)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("redirect:/addresses"));
		
		Address address = new Address(275, "123 Main St", 
				"Apt 1", "Denver", "CO", 12345);
		when(mockAddressService.getAddress(275)).thenReturn(address);
	}
}
