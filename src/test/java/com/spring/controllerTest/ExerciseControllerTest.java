package com.spring.controllerTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.time.Duration;
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
		mockMvc = standaloneSetup(controller).setSingleView(mockView)
                								.build();
	}
	
	@Test
	public void testListExercise() throws Exception {
		List<Exercise> expectedExercises = Arrays.asList(new Exercise(001, "Exercise1", 
				Duration.ofSeconds(120), 3, 12, null, null));
        when(mockExerciseService.listExercises()).thenReturn(expectedExercises);
        
        mockMvc.perform(get("/exercises"))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("listExercises", expectedExercises))
        		.andExpect(view().name("exercise"));
    }
	
	@Test
	public void testGetExercise() throws Exception {
		Exercise exercise = new Exercise(670, "Exercise2", 
				Duration.ofSeconds(120), 3, 12, null, null);
		mockExerciseService.addExercise(exercise);
		verify(mockExerciseService).addExercise(exercise);
        when(mockExerciseService.getExercise(exercise.getExerciseId()))
        		.thenReturn(exercise);
        
        mockMvc.perform(get("/exercise/{exerciseId}", 670))
        		.andExpect(status().isOk())
        		.andExpect(model().attribute("exercise", exercise))
        		.andExpect(view().name("exercise"));
        
        verify(mockExerciseService, times(2)).getExercise(670);
        verifyNoMoreInteractions(mockExerciseService);
    }
	
	@Test
	public void testAddExercise() throws Exception {
		mockMvc.perform(post("/exercise/add")
				.contentType(MediaType.TEXT_PLAIN)
				.content("exerciseId:890, name:\"Exercise3\","
					+ " duration:Duration.ofSeconds(120), numberOfSets:3,"
					+ " repsPerSet:12, routines:null,"
					+ " equipment:null "
					.getBytes())
			)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("redirect:/exercises"));
		
		Exercise exercise = new Exercise(890, "Exercise3", 
				Duration.ofSeconds(120), 3, 12, null, null);
		when(mockExerciseService.getExercise(890)).thenReturn(exercise);
    }
}

