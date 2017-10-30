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

import com.spring.controller.QualificationController;
import com.spring.model.Qualification;
import com.spring.service.QualificationService;

public class QualificationControllerTest {
	@InjectMocks
	QualificationController controller;
	
	@Mock
	QualificationService mockQualificationService;
	
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
	public void testListQualificationInGroup() {
		List<Qualification> expectedQualifications = Arrays.asList(new Qualification());
        when(mockQualificationService.listQualifications()).thenReturn(expectedQualifications);

        Model model = (Model) new Qualification();
        model.addAttribute("listQualifications", mockQualificationService.listQualifications());
        String viewName = controller.listQualifications(model);

        Assert.assertEquals("qualifications", viewName);
        Assert.assertTrue(model.containsAttribute("listQualifications"));
    }
	
	@Test
	public void testGetQualification() throws Exception {
		this.mockMvc.perform(get("/qualification/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.qualificationId").value(1));
    }
	
	@Test
	public void testAddQualification() throws Exception {
		Qualification qualification = new Qualification();
		qualification.setQualId(1);
		mockQualificationService.addQualification(qualification);

        Model model = (Model) new Qualification();
        model.addAttribute("listQualifications", mockQualificationService.listQualifications());
		
		this.mockMvc.perform(get("/qualification/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.qualificationId").value(1));
    }
}
