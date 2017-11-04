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

import com.spring.model.Exercise;
import com.spring.model.Trainer;

public class ExerciseTest {
    
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Exercise.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Exercise.class, "exerciseId", Column.class,
				Id.class, GeneratedValue.class);
		AssertAnnotations.assertField(Exercise.class, "name", Column.class);
		AssertAnnotations.assertField(Exercise.class, "duration", Column.class);
		AssertAnnotations.assertField(Exercise.class, "numberOfSets", Column.class);
		AssertAnnotations.assertField(Exercise.class, "repsPerSet", Column.class);
		AssertAnnotations.assertField(Exercise.class, "routines", ManyToMany.class);
		AssertAnnotations.assertField(Exercise.class, "equipment", ManyToMany.class, 
				JoinTable.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Exercise.class, "getExerciseId");
		AssertAnnotations.assertMethod(Exercise.class, "getName");
		AssertAnnotations.assertMethod(Exercise.class, "getDuration");
		AssertAnnotations.assertMethod(Exercise.class, "getNumberOfSets");
		AssertAnnotations.assertMethod(Exercise.class, "getRepsPerSet");
		AssertAnnotations.assertMethod(Exercise.class, "getRoutines");
		AssertAnnotations.assertMethod(Exercise.class, "getEquipment");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(Exercise.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(Exercise.class, Table.class);
		Assert.assertEquals("Exercise", table.name());
	}
	
	@Test
	public void id() {
		GeneratedValue genValue = ReflectTool.getMethodAnnotation(Exercise.class, 
				"exerciseId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void name() {
		Column column = ReflectTool.getFieldAnnotation(Exercise.class, 
				"name", Column.class);
		Assert.assertEquals("name", column.name());
	}
	
	@Test
	public void duration() {
		Column column = ReflectTool.getFieldAnnotation(Exercise.class, 
				"duration", Column.class);
		Assert.assertEquals("duration", column.name());
	}
	
	@Test
	public void equipment() {
		JoinTable joinTable = ReflectTool.getFieldAnnotation(Trainer.class, 
				"equipment", JoinTable.class);
		Assert.assertEquals("Exercise_Equipment", joinTable.name());
	}
}