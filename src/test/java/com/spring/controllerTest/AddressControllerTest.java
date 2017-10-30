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
import static org.mockito.Mockito.*;

import com.spring.controller.AddressController;
import com.spring.service.AddressService;
import com.spring.model.Address;

public class AddressControllerTest {
	@InjectMocks
	AddressController controller;
	
	@Mock
	AddressService mockAddressService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testListAddressInGroup() {
		List<Address> expectedAddresses = Arrays.asList(new Address());
        when(mockAddressService.listAddresses()).thenReturn(expectedAddresses);

        Model model = (Model) new Address();
        model.addAttribute("listAddresses", mockAddressService.listAddresses());
        String viewName = controller.listAddresses(model);

        Assert.assertEquals("addresses", viewName);
        Assert.assertTrue(model.containsAttribute("listAddresses"));
    }
}
