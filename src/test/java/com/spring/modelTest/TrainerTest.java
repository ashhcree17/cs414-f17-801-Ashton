package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.spring.model.Trainer;

public class TrainerTest {
    
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Trainer.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Trainer.class, "trainerId", Column.class,
				Id.class, GeneratedValue.class);
		AssertAnnotations.assertField(Trainer.class, "username", Column.class);
		AssertAnnotations.assertField(Trainer.class, "password", Column.class);
		AssertAnnotations.assertField(Trainer.class, "name", Column.class);
		AssertAnnotations.assertField(Trainer.class, "lastName", Column.class);
		AssertAnnotations.assertField(Trainer.class, "trainerAddressId", Column.class);
		AssertAnnotations.assertField(Trainer.class, "phoneNumber", Column.class);
		AssertAnnotations.assertField(Trainer.class, "email", Column.class);
		AssertAnnotations.assertField(Trainer.class, "insurance", Column.class);
		AssertAnnotations.assertField(Trainer.class, "workSchedule", OneToMany.class, 
				ElementCollection.class);
		AssertAnnotations.assertField(Trainer.class, "qualifications", 
				ManyToMany.class, JoinTable.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Trainer.class, "getTrainerId");
		AssertAnnotations.assertMethod(Trainer.class, "getUsername");
		AssertAnnotations.assertMethod(Trainer.class, "getPassword");
		AssertAnnotations.assertMethod(Trainer.class, "getName");
		AssertAnnotations.assertMethod(Trainer.class, "getLastName");
		AssertAnnotations.assertMethod(Trainer.class, "getTrainerAddressId");
		AssertAnnotations.assertMethod(Trainer.class, "getPhoneNumber");
		AssertAnnotations.assertMethod(Trainer.class, "getEmail");
		AssertAnnotations.assertMethod(Trainer.class, "getInsurance");
		AssertAnnotations.assertMethod(Trainer.class, "getWorkSchedule");
		AssertAnnotations.assertMethod(Trainer.class, "getQualifications");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(Trainer.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(Trainer.class, Table.class);
		Assert.assertEquals("Trainer", table.name());
	}
	
	@Test
	public void id() {
		GeneratedValue genValue = ReflectTool.getMethodAnnotation(Trainer.class, 
				"trainerId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void lastName() {
		Column column = ReflectTool.getMethodAnnotation(Trainer.class, 
				"lastName", Column.class);
		Assert.assertEquals("lastName", column.name());
	}
	
	@Test
	public void qualifications() {
		ManyToMany manyToMany = ReflectTool.getMethodAnnotation(Trainer.class, 
				"qualifications", ManyToMany.class);
		Assert.assertEquals(CascadeType.ALL, manyToMany.cascade());
	}
}