package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.spring.model.Manager;

@RunWith(SpringJUnit4ClassRunner.class)
public class ManagerTest {
	
	@Autowired
    private Manager manager;
    
    @Test
    public void verifyBeansConfigured() {
    		Assert.assertNotNull(manager); 
    }
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Manager.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Manager.class, "managerId", Id.class, 
				GeneratedValue.class);
		AssertAnnotations.assertField(Manager.class, "username", Column.class);
		AssertAnnotations.assertField(Manager.class, "password", Column.class);
		AssertAnnotations.assertField(Manager.class, "name", Column.class);
		AssertAnnotations.assertField(Manager.class, "lastName", Column.class);
		AssertAnnotations.assertField(Manager.class, "managerAddressId",
				Column.class);
		AssertAnnotations.assertField(Manager.class, "phoneNumber", Column.class);
		AssertAnnotations.assertField(Manager.class, "email", Column.class);
		AssertAnnotations.assertField(Manager.class, "insurance", Column.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Manager.class, "getManagerId");
		AssertAnnotations.assertMethod(Manager.class, "getUsername");
		AssertAnnotations.assertMethod(Manager.class, "getPassword");
		AssertAnnotations.assertMethod(Manager.class, "getName");
		AssertAnnotations.assertMethod(Manager.class, "getLastName");
		AssertAnnotations.assertMethod(Manager.class, "getManagerAddressId");
		AssertAnnotations.assertMethod(Manager.class, "getPhoneNumber");
		AssertAnnotations.assertMethod(Manager.class, "getEmail");
		AssertAnnotations.assertMethod(Manager.class, "getInsurance");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(Manager.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(Manager.class, Table.class);
		Assert.assertEquals("Manager", table.name());
	}
	
	@Test
	public void id() {
		GeneratedValue genValue = ReflectTool.getMethodAnnotation(Manager.class, 
				"getManagerId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void lastName() {
		Column column = ReflectTool.getMethodAnnotation(Manager.class, 
				"getLastName", Column.class);
		Assert.assertEquals("lastName", column.name());
	}
	
	@Test
	public void phoneNumber() {
		Column column = ReflectTool.getMethodAnnotation(Manager.class, 
				"getPhoneNumber", Column.class);
		Assert.assertEquals("phoneNumber", column.name());
	}
}