package main.controller.globoGymMS;

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

import main.model.globoGymMS.Address;
import main.service.globoGymMS.AddressService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	
//	private Address prepareModel(AddressBean addressBean) {
//		Address address= new Address();
//		address.setAddressId(addressBean.getAddressId());
//		address.setStreet1(addressBean.getStreet1());
//		address.setStreet2(addressBean.getStreet2());
//		address.setCity(addressBean.getCity());
//		address.setState(addressBean.getState());
//		address.setZipCode(addressBean.getZipCode());
//		addressBean.setAddressId(null);
//		return address;
//	}
//	
//	private List<AddressBean> prepareListOfBean(List<Address> addresss) {
//		List<AddressBean> beans = null;
//		if (addresss != null && !addresss.isEmpty()) {
//			beans = new ArrayList<AddressBean>();
//			AddressBean bean = null;
//			for (Address address : addresss) {
//				bean = new AddressBean();
//				bean.setAddressId(address.getAddressId());
//				bean.setStreet1(address.getStreet1());
//				bean.setStreet2(address.getStreet2());
//				bean.setCity(address.getCity());
//				bean.setState(address.getState());
//				bean.setZipCode(address.getZipCode());
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}
//	
//	private AddressBean prepareAddressBean(Address address) {
//		AddressBean bean = new AddressBean();
//		bean.setAddressId(address.getAddressId());
//		bean.setStreet1(address.getStreet1());
//		bean.setStreet2(address.getStreet2());
//		bean.setCity(address.getCity());
//		bean.setState(address.getState());
//		bean.setZipCode(address.getZipCode());
//		return bean;
//	}
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ModelAndView saveAddress(@ModelAttribute("command")AddressBean addressBean,
//			BindingResult result) {
//		Address address = prepareModel(addressBean);
//		addressService.addAddress(address);
//		return new ModelAndView("addAddress");
//	}
//	
//	@RequestMapping(value = "/addresses", method = RequestMethod.GET) 
//	public ModelAndView listAddresss() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("addresses", prepareListOfBean(addressService.listAddresses()));
//		return new ModelAndView("addAddress", model);
//	}
//	
//	@RequestMapping(value = "/add", method = RequestMethod.GET) 
//	public ModelAndView addAddress(@ModelAttribute("command")AddressBean addressBean,
//			BindingResult result){
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("addresses", prepareListOfBean(addressService.listAddresses()));
//		return new ModelAndView("addAddress", model);
//	}
//	
//	@RequestMapping(value = "/index", method = RequestMethod.GET) 
//	public ModelAndView welcome() {
//		return new ModelAndView("index");
//	}
//	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public ModelAndView editAddress(@ModelAttribute("command")AddressBean addressBean,
//			BindingResult result) {
//		addressService.deleteAddress(prepareModel(addressBean));
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("address", null);
//		model.put("addresses", prepareListOfBean(addressService.listAddresses()));
//		return new ModelAndView("addAddress", model);
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public ModelAndView deleteAddress(@ModelAttribute("command")AddressBean addressBean,
//			BindingResult result) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("address", prepareAddressBean(addressService.getAddress(addressBean.getAddressId())));
//		model.put("addresses", prepareListOfBean(addressService.listAddresses()));
//		return new ModelAndView("addAddress", model);
//	}
}
