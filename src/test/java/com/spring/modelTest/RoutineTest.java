package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.spring.model.Routine;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RoutineTest {
	
	@Autowired
    private Routine routine;
    
    @Test
    public void verifyBeansConfigured() {
    		Assert.assertNotNull(routine); 
    }
	
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Routine.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Routine.class, "routineId", Id.class, 
				GeneratedValue.class);
		AssertAnnotations.assertField(Routine.class, "name", Column.class);
		AssertAnnotations.assertField(Routine.class, "exercises", Column.class,
				ManyToMany.class, JoinTable.class);
		AssertAnnotations.assertField(Routine.class, "customers", Column.class,
				ManyToMany.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Routine.class, "getRoutineId");
		AssertAnnotations.assertMethod(Routine.class, "getName");
		AssertAnnotations.assertMethod(Routine.class, "getExercises");
		AssertAnnotations.assertMethod(Routine.class, "getRoutines");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(Routine.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(Routine.class, Table.class);
		Assert.assertEquals("Routine", table.name());
	}
	
	@Test
	public void id() {
		GeneratedValue genValue = ReflectTool.getMethodAnnotation(Routine.class, 
				"getRoutineId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void name() {
		Column column = ReflectTool.getMethodAnnotation(Routine.class, 
				"getName", Column.class);
		Assert.assertEquals("name", column.name());
	}
	
	@Test
	public void exercises() {
		ManyToMany manyToMany = ReflectTool.getMethodAnnotation(Routine.class, 
				"getExercises", ManyToMany.class);
		Assert.assertEquals(CascadeType.ALL, manyToMany.cascade());
	}
}