package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.spring.model.Customer;
import com.spring.service.CustomerService;

@Controller
public class CustomerController {
	private CustomerService customerService;
	
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCustomerService(CustomerService customerService){
		this.customerService = customerService;
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomers", this.customerService.listCustomers());
		return "customer";
	}
	
	//For add and update person both
	@RequestMapping(value= "/customer/add", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer customer){
		if (customer.getCustomerId() == 0) {
			// Denotes a new Customer - to be added
			this.customerService.addCustomer(customer);
		} else {
			// Denotes an existing Customer - to be updated
			this.customerService.updateCustomer(customer);
		}
		
		return "redirect:/customers";
	}
	
	@RequestMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") int customerId){
        this.customerService.deleteCustomer(customerId);
        return "redirect:/customers";
    }
 
    @RequestMapping("/edit/{customerId}")
    public String editCustomer(@PathVariable("customerId") int customerId, Model model){
        model.addAttribute("person", this.customerService.getCustomer(customerId));
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "customer";
    }
}
