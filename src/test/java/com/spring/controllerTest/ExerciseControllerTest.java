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

import com.spring.controller.ExerciseController;
import com.spring.model.Exercise;
import com.spring.service.ExerciseService;

public class ExerciseControllerTest {
	@InjectMocks
	ExerciseController controller;
	
	@Mock
	ExerciseService mockExerciseService;
	
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
	public void testListExerciseInGroup() {
		List<Exercise> expectedExercises = Arrays.asList(new Exercise());
        when(mockExerciseService.listExercises()).thenReturn(expectedExercises);

        Model model = (Model) new Exercise();
        model.addAttribute("listExercises", mockExerciseService.listExercises());
        String viewName = controller.listExercises(model);

        Assert.assertEquals("exercises", viewName);
        Assert.assertTrue(model.containsAttribute("listExercises"));
    }
	
	@Test
	public void testGetExercise() throws Exception {
		this.mockMvc.perform(get("/exercise/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.exerciseId").value(1));
    }
	
	@Test
	public void testAddExercise() throws Exception {
		Exercise exercise = new Exercise();
		exercise.setExerciseId(1);
		mockExerciseService.addExercise(exercise);

        Model model = (Model) new Exercise();
        model.addAttribute("listExercises", mockExerciseService.listExercises());
		
		this.mockMvc.perform(get("/exercise/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.exerciseId").value(1));
    }
}

