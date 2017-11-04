package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.spring.model.Address;

public class AddressTest {
	
	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(Address.class, Entity.class, Table.class);
	}
	
	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(Address.class, "addressId", Column.class,
				Id.class, GeneratedValue.class);
		AssertAnnotations.assertField(Address.class, "street1", Column.class);
		AssertAnnotations.assertField(Address.class, "street2", Column.class);
		AssertAnnotations.assertField(Address.class, "city", Column.class);
		AssertAnnotations.assertField(Address.class, "state", Column.class);
		AssertAnnotations.assertField(Address.class, "zipCode", Column.class);
	}
	
	@Test
	public void methodAnnotations() {
		AssertAnnotations.assertMethod(Address.class, "getAddressId");
		AssertAnnotations.assertMethod(Address.class, "getStreet1");
		AssertAnnotations.assertMethod(Address.class, "getStreet2");
		AssertAnnotations.assertMethod(Address.class, "getCity");
		AssertAnnotations.assertMethod(Address.class, "getState");
		AssertAnnotations.assertMethod(Address.class, "getZipCode");
	}
	
	@Test
	public void entity() {
		Entity entity = ReflectTool.getClassAnnotation(Address.class, Entity.class);
		Assert.assertEquals("", entity.name());
	}
	
	@Test
	public void table() {
		Table table = ReflectTool.getClassAnnotation(Address.class, Table.class);
		Assert.assertEquals("Address", table.name());
	}
	
	@Test
	public void id() {
		Id addressId = ReflectTool.getFieldAnnotation(Address.class, 
				"addressId", Id.class);
		Assert.assertEquals(Id.class, addressId.annotationType());
	}
	
	@Test
	public void city() {
		Column column = ReflectTool.getFieldAnnotation(Address.class, 
				"city", Column.class);
		Assert.assertEquals("city", column.name());
	}
	
	@Test
	public void zipCode() {
		Column column = ReflectTool.getFieldAnnotation(Address.class, 
				"zipCode", Column.class);
		Assert.assertEquals("zipCode", column.name());
	}
}