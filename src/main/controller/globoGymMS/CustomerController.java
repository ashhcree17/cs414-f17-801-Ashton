package globoGymMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import globoGymMS.Customer;
import globoGymMS.CustomerBean;
import globoGymMS.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	private Customer prepareModel(CustomerBean customerBean) {
		Customer customer = new Customer();
		customer.setId(customerBean.getId());
		customer.setName(customerBean.getName());
		customer.setLastName(customerBean.getLastName());
		customer.setAddress(customerBean.getAddress());
		customer.setPhoneNumber(customerBean.getPhoneNumber());
		customer.setEmail(customerBean.getEmail());
		customer.setInsurance(customerBean.getInsurance());
		customer.setMembership(customerBean.getMembership());
		customer.setAssignedRoutines(customerBean.getAssignedRoutines());
		customerBean.setId(null);
		return customer;
	}
	
	private List<CustomerBean> prepareListOfBean(List<Customer> customers) {
		List<CustomerBean> beans = null;
		if (customers != null && !customers.isEmpty()) {
			beans = new ArrayList<CustomerBean>();
			CustomerBean bean = null;
			for (Customer customer : customers) {
				bean = new CustomerBean();
				bean.setId(customer.getId());
				bean.setName(customer.getName());
				bean.setLastName(customer.getLastName());
				bean.setAddress(customer.getAddress());
				bean.setPhoneNumber(customer.getPhoneNumber());
				bean.setEmail(customer.getEmail());
				bean.setInsurance(customer.getInsurance());
				bean.setMembership(customer.getMembership());
				bean.setAssignedRoutines(customer.getAssignedRoutines());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private CustomerBean prepareCustomerBean(Customer customer) {
		CustomerBean bean = new CustomerBean();
		bean.setId(customer.getId());
		bean.setName(customer.getName());
		bean.setLastName(customer.getLastName());
		bean.setAddress(customer.getAddress());
		bean.setPhoneNumber(customer.getPhoneNumber());
		bean.setEmail(customer.getEmail());
		bean.setInsurance(customer.getInsurance());
		bean.setMembership(customer.getMembership());
		bean.setAssignedRoutines(customer.getAssignedRoutines());
		return bean;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute("command")CustomerBean customerBean,
			BindingResult result) {
		Customer customer = prepareModel(customerBean);
		customerService.addCustomer(customer);
		return new ModelAndView("addCustomer");
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET) 
	public ModelAndView listCustomers() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customers", prepareListOfBean(customerService.listCustomers()));
		return new ModelAndView("addCustomer", model);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET) 
	public ModelAndView addCustomer(@ModelAttribute("command")CustomerBean customerBean,
			BindingResult result){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customers", prepareListOfBean(customerService.listCustomers()));
		return new ModelAndView("addCustomer", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editCustomer(@ModelAttribute("command")CustomerBean customerBean,
			BindingResult result) {
		customerService.deleteCustomer(prepareModel(customerBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customer", null);
		model.put("customers", prepareListOfBean(customerService.listCustomers()));
		return new ModelAndView("addCustomer", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@ModelAttribute("command")CustomerBean customerBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customer", prepareCustomerBean(customerService.getCustomer(customerBean.getId())));
		model.put("customers", prepareListOfBean(customerService.listCustomers()));
		return new ModelAndView("addEmployee", model);
	}
}
