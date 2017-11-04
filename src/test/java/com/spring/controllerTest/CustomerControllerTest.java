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

import com.spring.controller.CustomerController;
import com.spring.model.Customer;
import com.spring.service.CustomerService;
import com.spring.model.MembershipStatus;

public class CustomerControllerTest {
	@InjectMocks
	CustomerController controller;
	
	@Mock
	CustomerService mockCustomerService;
	
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
	public void testListCustomer() throws Exception {
		List<Customer> expectedCustomers = Arrays.asList(new Customer(001, "Joe", "Smith", 001, 
				1234567890, "joe@email.com", "Aetna", MembershipStatus.ACTIVE));
        when(mockCustomerService.listCustomers()).thenReturn(expectedCustomers);
        
        mockMvc.perform(get("/customers"))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("listCustomers", expectedCustomers))
        		.andExpect(view().name("customer"));
    }
	
	@Test
	public void testGetCustomer() throws Exception {
		Customer expectedCustomer = new Customer(002, "Joe", "Smith", 002, 
				1234567890, "joe@email.com", "Aetna", MembershipStatus.ACTIVE);
		mockCustomerService.addCustomer(expectedCustomer);
        when(mockCustomerService.getCustomer(expectedCustomer.getCustomerId()))
        		.thenReturn(expectedCustomer);
        
        mockMvc.perform(get("/customer/" + expectedCustomer.getCustomerId()))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("customer", expectedCustomer))
        		.andExpect(view().name("customer"));
    }
	
	@Test
	public void testAddCustomer() throws Exception {
		mockMvc.perform(post("/customer/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("customerId:003, name:\"Joe\","
					+ " lastName:\"Smith\", customerCustomerId:003,"
					+ " phoneNumber:1234567890, email:\"joe@email.com\","
					+ " insurance:\"Aetna\", membership:MembershipStatus.ACTIVE"
					.getBytes())
			)
			.andExpect(status().isCreated())
			.andExpect(view().name("redirect:/customers"));
		
		verify(mockCustomerService).addCustomer(new Customer(003, "Joe", 
				"Smith", 003, 1234567890, "joe@email.com", "Aetna", MembershipStatus.ACTIVE));
    }
}
