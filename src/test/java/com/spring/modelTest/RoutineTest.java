package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.spring.model.Routine;
import com.spring.model.Trainer;

public class RoutineTest {
	
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Routine.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Routine.class, "routineId", Column.class,
				Id.class, GeneratedValue.class);
		AssertAnnotations.assertField(Routine.class, "name", Column.class);
		AssertAnnotations.assertField(Routine.class, "exercises", ManyToMany.class, 
				JoinTable.class);
		AssertAnnotations.assertField(Routine.class, "customers", ManyToMany.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Routine.class, "getRoutineId");
		AssertAnnotations.assertMethod(Routine.class, "getName");
		AssertAnnotations.assertMethod(Routine.class, "getExercises");
		AssertAnnotations.assertMethod(Routine.class, "getCustomers");
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
		GeneratedValue genValue = ReflectTool.getFieldAnnotation(Routine.class, 
				"routineId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void name() {
		Column column = ReflectTool.getFieldAnnotation(Routine.class, 
				"name", Column.class);
		Assert.assertEquals("name", column.name());
	}
	
	@Test
	public void exercises() {
		JoinTable joinTable = ReflectTool.getFieldAnnotation(Trainer.class, 
				"exercises", JoinTable.class);
		Assert.assertEquals("Routine_Exercise", joinTable.name());
	}
}