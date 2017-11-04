package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.spring.model.Equipment;

public class EquipmentTest {
    
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Equipment.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Equipment.class, "equipmentId", Column.class,
				Id.class, GeneratedValue.class);
		AssertAnnotations.assertField(Equipment.class, "name", Column.class);
//		AssertAnnotations.assertField(Equipment.class, "picture", Column.class);
		AssertAnnotations.assertField(Equipment.class, "quantity", Column.class);
		AssertAnnotations.assertField(Equipment.class, "exercises", ManyToMany.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Equipment.class, "getEquipmentId");
		AssertAnnotations.assertMethod(Equipment.class, "getName");
//		AssertAnnotations.assertMethod(Equipment.class, "getPicture");
		AssertAnnotations.assertMethod(Equipment.class, "getQuantity");
		AssertAnnotations.assertMethod(Equipment.class, "getExercises");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(Equipment.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(Equipment.class, Table.class);
		Assert.assertEquals("Equipment", table.name());
	}
	
	@Test
	public void id() {
		GeneratedValue genValue = ReflectTool.getFieldAnnotation(Equipment.class, 
				"equipmentId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void name() {
		Column column = ReflectTool.getFieldAnnotation(Equipment.class, 
				"name", Column.class);
		Assert.assertEquals("name", column.name());
	}
	
	@Test
	public void exercises() {
		ManyToMany manyToMany = ReflectTool.getFieldAnnotation(Equipment.class, 
				"exercises", ManyToMany.class);
		Assert.assertEquals("equipment", manyToMany.mappedBy());
	}
}