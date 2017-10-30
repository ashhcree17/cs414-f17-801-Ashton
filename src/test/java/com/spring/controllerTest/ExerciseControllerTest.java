package com.spring.controllerTest;

import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.spring.controller.ExerciseController;
import com.spring.model.Exercise;
import com.spring.service.ExerciseService;

public class ExerciseControllerTest {
	@InjectMocks
	ExerciseController controller;
	
	@Mock
	ExerciseService mockExerciseService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
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
}

