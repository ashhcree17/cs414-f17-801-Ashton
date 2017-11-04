package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.spring.model.Customer;

public class CustomerTest {
	
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Customer.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Customer.class, "customerId", Column.class,
				Id.class, GeneratedValue.class);
		AssertAnnotations.assertField(Customer.class, "name", Column.class);
		AssertAnnotations.assertField(Customer.class, "lastName", Column.class);
		AssertAnnotations.assertField(Customer.class, "customerAddressId",
				Column.class);
		AssertAnnotations.assertField(Customer.class, "phoneNumber", Column.class);
		AssertAnnotations.assertField(Customer.class, "email", Column.class);
		AssertAnnotations.assertField(Customer.class, "insurance", Column.class);
		AssertAnnotations.assertField(Customer.class, "membership", Column.class);
		AssertAnnotations.assertField(Customer.class, "assignedRoutines", 
				ManyToMany.class, JoinTable.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Customer.class, "getCustomerId");
		AssertAnnotations.assertMethod(Customer.class, "getName");
		AssertAnnotations.assertMethod(Customer.class, "getLastName");
		AssertAnnotations.assertMethod(Customer.class, "getCustomerAddressId");
		AssertAnnotations.assertMethod(Customer.class, "getPhoneNumber");
		AssertAnnotations.assertMethod(Customer.class, "getEmail");
		AssertAnnotations.assertMethod(Customer.class, "getInsurance");
		AssertAnnotations.assertMethod(Customer.class, "getMembership");
		AssertAnnotations.assertMethod(Customer.class, "getAssignedRoutines");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(Customer.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(Customer.class, Table.class);
		Assert.assertEquals("Customer", table.name());
	}
	
	@Test
	public void id() {
		GeneratedValue genValue = ReflectTool.getMethodAnnotation(Customer.class, 
				"getCustomerId", GeneratedValue.class);
		Assert.assertEquals("", genValue.generator());
	}
	
	@Test
	public void lastName() {
		Column column = ReflectTool.getMethodAnnotation(Customer.class, 
				"getLastName", Column.class);
		Assert.assertEquals("lastName", column.name());
	}
	
	@Test
	public void assignedRoutines() {
		ManyToMany manyToMany = ReflectTool.getMethodAnnotation(Customer.class, 
				"getAssignedRoutines", ManyToMany.class);
		Assert.assertEquals(CascadeType.ALL, manyToMany.cascade());
	}
}