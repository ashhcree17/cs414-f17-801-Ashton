package com.spring.modelTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import javax.persistence.Entity;
import javax.persistence.Table;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.spring.model.Address;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressTest {
	@Test
	public void typeAnnotations() {
    // assert
		AssertAnnotations.assertType(
				Address.class, Entity.class, Table.class);
	}
     
  @Test
  public void fieldAnnotations() {
    // assert
    AssertAnnotations.assertField(Address.class, "addressId");
    AssertAnnotations.assertField(Address.class, "street1");
    AssertAnnotations.assertField(Address.class, "street2");
    AssertAnnotations.assertField(Address.class, "city");
    AssertAnnotations.assertField(Address.class, "state");
    AssertAnnotations.assertField(Address.class, "zipCode");
  }
  @Test
  public void methodAnnotations() {
    // assert
    AssertAnnotations.assertMethod(
        Address.class, "getAddressId", Id.class, GeneratedValue.class);
    AssertAnnotations.assertMethod(
        Address.class, "getStreet1", Column.class);
    AssertAnnotations.assertMethod(
        Address.class, "getStreet2", Column.class);
    AssertAnnotations.assertMethod(
        Address.class, "getCity", Column.class);
    AssertAnnotations.assertMethod(
            Address.class, "getState", Column.class);
    AssertAnnotations.assertMethod(
            Address.class, "getZipCode", Column.class);
  }
  @Test
  public void entity() {
    // setup
    Entity a
    = ReflectTool.getClassAnnotation(Address.class, Entity.class);
    // assert
    Assert.assertEquals("", a.name());
  }
  @Test
  public void table() {
    // setup
    Table t
    = ReflectTool.getClassAnnotation(Address.class, Table.class);
    // assert
    Assert.assertEquals("T_PERSON", t.name());
  }
  @Test
  public void id() {
    // setup
    GeneratedValue a
    = ReflectTool.getMethodAnnotation(
        Address.class, "getId", GeneratedValue.class);
    // assert
    Assert.assertEquals("", a.generator());
    Assert.assertEquals(GenerationType.AUTO, a.strategy());
  }
  @Test
  public void firstName() {
    // setup
    Column c
    = ReflectTool.getMethodAnnotation(
        Address.class, "getFirstName", Column.class);
    // assert
    Assert.assertEquals("FIRST_NAME", c.name());
  }
  @Test
  public void lastName() {
    // setup
    Column c
    = ReflectTool.getMethodAnnotation(
        Address.class, "getLastName", Column.class);
    // assert
    Assert.assertEquals("LAST_NAME", c.name());
  }
  @Test
  public void phones() {
    // setup
    OneToMany a
    = ReflectTool.getMethodAnnotation(
        Address.class, "getPhones", OneToMany.class);
    // assert
    Assert.assertEquals("person", a.mappedBy());
    Assert.assertEquals(FetchType.LAZY, a.fetch());
  }
}