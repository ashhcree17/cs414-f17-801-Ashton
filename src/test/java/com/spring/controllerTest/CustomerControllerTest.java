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

import com.spring.controller.CustomerController;
import com.spring.model.Customer;
import com.spring.service.CustomerService;

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
		mockMvc = standaloneSetup(controller)
                .setSingleView(mockView)
                .build();
	}
	
	@Test
	public void testListCustomerInGroup() {
		List<Customer> expectedCustomers = Arrays.asList(new Customer());
        when(mockCustomerService.listCustomers()).thenReturn(expectedCustomers);

        Model model = (Model) new Customer();
        model.addAttribute("listCustomers", mockCustomerService.listCustomers());
        String viewName = controller.listCustomers(model);

        Assert.assertEquals("customers", viewName);
        Assert.assertTrue(model.containsAttribute("listCustomers"));
    }
	
	@Test
	public void testGetCustomer() throws Exception {
		this.mockMvc.perform(get("/customer/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.customerId").value(1));
    }
	
	@Test
	public void testAddCustomer() throws Exception {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		mockCustomerService.addCustomer(customer);

        Model model = (Model) new Customer();
        model.addAttribute("listCustomers", mockCustomerService.listCustomers());
		
		this.mockMvc.perform(get("/customer/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.customerId").value(1));
    }
}
