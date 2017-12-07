package csu.springmvc.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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

import csu.springmvc.controller.WorkScheduleController;

@ContextConfiguration(locations = { "classpath:csu/config/beans.xml" })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkScheduleControllerTest {
  
  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;
  
  @Before
  public void setup() {
      this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }
  
  @Test
  public void testCreateWorkSchedule() {
      WorkScheduleController workScheduleController = new WorkScheduleController();
      ModelAndView mav = workScheduleController.createWorkSchedule(null, null);
      Assert.assertEquals("createWorkSchedule", mav.getViewName());
  }

  @Test
  public void testCreateWorkScheduleProcess() throws Exception {
    this.mockMvc.perform(post("/createWorkScheduleProcess")
        .param("workScheduleid", "78923")
        .param("day", "2017-11-23")
        .param("startTime", "08:30 AM")
        .param("endTime", "10:30 PM")
          )
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("successWorkSchedule"))
        .andExpect(model().attribute("day", any(String.class)));
  }
}
