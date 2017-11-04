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
	public void testListQualification() throws Exception {
		List<Qualification> expectedQualifications = Arrays.asList(new 
				Qualification(001, "Qual1", null));
        when(mockQualificationService.listQualifications()).thenReturn(expectedQualifications);
        
        mockMvc.perform(get("/qualifications"))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("listQualifications", expectedQualifications))
        		.andExpect(view().name("qualification"));
    }
	
	@Test
	public void testGetQualification() throws Exception {
		Qualification expectedQualification = new Qualification(002, "Qual2", null);
        when(mockQualificationService.getQualification(
    				expectedQualification.getQualId()))
        .thenReturn(expectedQualification);
        
        mockMvc.perform(get("/qualification/" + expectedQualification.getQualId()))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("qualification", expectedQualification))
        		.andExpect(view().name("qualification"));
    }
	
	@Test
	public void testAddQualification() throws Exception {
		mockMvc.perform(post("/qualification/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("qualId:003, name:\"Qual3\", trainers:null "
					.getBytes())
			)
			.andExpect(status().isCreated())
			.andExpect(view().name("redirect:/qualifications"));
		
		verify(mockQualificationService).addQualification(new 
				Qualification(003, "Qual1", null));
    }
}
