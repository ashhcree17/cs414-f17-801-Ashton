package csu.springmvc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import csu.springmvc.controller.AddressController;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressControllerTest {
  
  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;
  
  @Before
  public void setup() {
      this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }
  
  @Test
  public void testCreateAddress() {
      AddressController addressController = new AddressController();
      ModelAndView mav = addressController.createAddress(null, null);
      Assert.assertEquals("createAddress", mav.getViewName());
  }

  @Test
  public void testCreateAddressProcess() throws Exception {
    this.mockMvc.perform(post("/createAddressProcess")
        .param("addressid", "78914")
        .param("street1", "123 Main St")
        .param("street2", "Apt 123")
        .param("city", "Denver")
        .param("state", "CO")
        .param("zipCode", "12345")
          )
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("successAddress"))
        .andExpect(model().attribute("street1", any(String.class)));
  }
}
