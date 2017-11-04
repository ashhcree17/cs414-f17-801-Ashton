package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.spring.model.Qualification;

public class QualificationTest {
    
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Qualification.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Qualification.class, "qualId", Column.class,
				Id.class, GeneratedValue.class);
		AssertAnnotations.assertField(Qualification.class, "name", Column.class);
		AssertAnnotations.assertField(Qualification.class, "trainers", ManyToMany.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Qualification.class, "getQualId");
		AssertAnnotations.assertMethod(Qualification.class, "getName");
		AssertAnnotations.assertMethod(Qualification.class, "getTrainers");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(Qualification.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(Qualification.class, Table.class);
		Assert.assertEquals("Qualification", table.name());
	}
	
	@Test
	public void id() {
		GeneratedValue genValue = ReflectTool.getFieldAnnotation(Qualification.class, 
				"qualId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void name() {
		Column column = ReflectTool.getFieldAnnotation(Qualification.class, 
				"name", Column.class);
		Assert.assertEquals("name", column.name());
	}
	
	@Test
	public void trainers() {
		ManyToMany manyToMany = ReflectTool.getFieldAnnotation(Qualification.class, 
				"trainers", ManyToMany.class);
		Assert.assertEquals(CascadeType.ALL, manyToMany.cascade());
	}
}