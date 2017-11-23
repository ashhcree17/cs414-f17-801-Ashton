package csu.springmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest {
  
  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;
  
  @Before
  public void setup() {
      this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }
  
  @Test
  public void testLogin() {
      LoginController loginController = new LoginController();
      ModelAndView mav = loginController.showLogin(null, null);
      Assert.assertEquals("login", mav.getViewName());
  }

  @Test
  public void testLoginProcessForManager() throws Exception {
    this.mockMvc.perform(post("/loginProcess")
        .param("username", "joesmith")
        .param("password", "iLOVEtheGYM21")
          )
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("welcomeManager"));
  }

  @Test
  public void testLoginProcessForTrainer() throws Exception {
    this.mockMvc.perform(post("/loginProcess")
        .param("username", "joesmith12")
        .param("password", "iLOVEtheGYM21")
          )
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("welcomeTrainer"));
  }
}
